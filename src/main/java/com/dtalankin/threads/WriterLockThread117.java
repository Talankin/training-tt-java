/**
 *  19.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.locks.ReadWriteLock;
import static com.dtalankin.Print.print;

public class WriterLockThread117 extends Thread{
    private ReadWriteLock lock;

    public WriterLockThread117(ReadWriteLock lock) {
        super();
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        print("  writer " + this.getId() + " is waiting for lock");
        lock.writeLock().lock();
        Shared.count++;
        print("  writer " + this.getId() + " is in the lock; count = " + Shared.count);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            print("  writer " + this.getId() + " goes to unlock");
            lock.writeLock().unlock();
        }

    }
}
