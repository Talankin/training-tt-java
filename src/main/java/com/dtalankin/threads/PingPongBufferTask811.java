/**
 *  09.02.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPongBufferTask811 {
    private Lock lock = new ReentrantLock();
    private Condition pingIsFree = lock.newCondition();
    private Condition pongIsFree = lock.newCondition();
    private boolean flag = false;

    public void ping(int i) throws InterruptedException {
        lock.lock();
        try {
            while (flag) {
                pingIsFree.await();
            }
            System.out.println("ping");
            flag = true;
            pongIsFree.signal();
        } finally {
            lock.unlock();
        }
    }


    public void pong(int i) throws InterruptedException {
        lock.lock();
        try {
            while (!flag) {
                pongIsFree.await();
            }
            System.out.println("pong");
            flag = false;
            pingIsFree.signal();
        } finally {
            lock.unlock();
        }
    }
}