/**
 *  19.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.locks.ReentrantLock;

import static com.dtalankin.Print.print;

public class LockThreadB116 {
    private String name;
    private ReentrantLock lock;
    public Thread t;

    public LockThreadB116(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
        t = new Thread(runnable, name);
        t.start();
    }

    private Runnable runnable = ()->{

        print(name + " is waiting for lock");
        lock.lock();
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
