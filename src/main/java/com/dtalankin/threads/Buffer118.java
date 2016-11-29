/**
 *  27.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static com.dtalankin.Print.*;

public class Buffer118 {
    private Lock lock = new ReentrantLock();
    private Condition isFull = lock.newCondition();
    private Condition isEmpty = lock.newCondition();
    private int count, putIndex, getIndex;
    private int bufferSize = 5;
    private int buffer[] = new int[bufferSize];


    public void put(int n) {
        lock.lock();
        try {
            while (count == buffer.length) {
                isFull.await();
            }
            print("put " + n);
            putIntoBuffer(n);
            isEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    private void putIntoBuffer (int value) {
        buffer[putIndex] = value;
        if (++putIndex == buffer.length) {
            putIndex = 0;
        }
        ++count;
    }

    public void take() {
        lock.lock();
        try {
            while (count == 0) {
                isEmpty.await();
            }
            print("get " + getFromBuffer());
            isFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    private int getFromBuffer () {
        int x = buffer[getIndex];
        if (++getIndex == buffer.length) {
            getIndex = 0;
        }
        --count;
        return x;
    }
}

