/**
 *  19.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.locks.Lock;

import static com.dtalankin.Print.print;

public class LockThread116 {
    private String name;
    private Lock lock;
    public Thread t;

    public LockThread116(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        t = new Thread(runnable, name);
        t.start();
    }

    private Runnable runnable = ()->{
        print(name + " is waiting for lock");
        lock.lock();
//        lock.lock(); I can do it, but then I should unlock one more
        print(name + " is locked");
        Shared.count++;
        try {
            print(name + " go to sleep. count = " + Shared.count);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            print(name + " unlock");
            lock.unlock();
        }
    };
}
