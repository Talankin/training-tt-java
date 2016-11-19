/**
 *  19.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.locks.ReadWriteLock;

import static com.dtalankin.Print.print;

public class ReaderLockThread117 extends Thread{
    private ReadWriteLock lock;

    public ReaderLockThread117(ReadWriteLock lock) {
        super();
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        print("reader " + this.getId() + " is waiting for lock");
        lock.readLock().lock();
        print("reader " + this.getId() + " is in the lock; count = " + Shared.count);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            print("reader " + this.getId() + " goes to unlock");
            lock.readLock().unlock();
        }

    }

}
