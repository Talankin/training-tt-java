/**
 *  01.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Semaphore;

import static com.dtalankin.Print.print;

public class Product112 {
    private int n;
    Semaphore semaphoreCon = new Semaphore(0);
    Semaphore semaphorePro = new Semaphore(1);

    public synchronized int get() {
        try {
            semaphoreCon.acquire();
            print("Get " + n);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphorePro.release();
        return n;
    }

    public synchronized void put (int n) {
        try {
            semaphorePro.acquire();
            this.n = n;
            print("Put " + n);
//            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphoreCon.release();
    }
}
