/**
 *  20.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBuffer {
    final private Lock lock = new ReentrantLock();
    final private Condition notFull = lock.newCondition();
    final private Condition notEmpty = lock.newCondition();

    final private int bufferSize = 5;
    final private int[] items = new int[bufferSize];
    private  int putIndex, takeIndex, count;

    public void put(int x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            putIntoBuffer(x);
            notEmpty.signal();
            Thread.sleep(5000);
        } finally {
            lock.unlock();
        }
    }

    private void putIntoBuffer(int x) {
        items[putIndex] = x;
        if (++putIndex == items.length)
            putIndex = 0;
        ++count;
    }

    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            int x = getFromBuffer();
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

    private int getFromBuffer() {
        int x = items[takeIndex];
        if (++takeIndex == items.length)
            takeIndex = 0;
        --count;
        return x;
    }
}

class Producer extends Thread {
    private BoundedBuffer buffer;
    private int objectsToPut;

    public Producer(BoundedBuffer sharedBuffer, int objectsToPut) {
        this.buffer = sharedBuffer;
        this.objectsToPut = objectsToPut;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < objectsToPut; i++) {
                System.out.println("put " + i);
                buffer.put(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private BoundedBuffer buffer;
    private int objectsToGet;

    public Consumer(BoundedBuffer sharedBuffer, int objectsToGet) {
        this.buffer = sharedBuffer;
        this.objectsToGet = objectsToGet;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < objectsToGet; i++) {
                System.out.println("get " + buffer.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ConditionDemo {

    public static void main(String[] args) {

        BoundedBuffer sharedObject = new BoundedBuffer();

        Producer p = new Producer(sharedObject, 200);
        Consumer c = new Consumer(sharedObject, 200);

        p.start();
        c.start();

        try {
            p.join();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}