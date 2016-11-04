/**
 *  01.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Semaphore;

import static com.dtalankin.Print.print;

public class Product112 {
    private int n;
    private Semaphore semaphoreCon = new Semaphore(0);
    private Semaphore semaphorePro = new Semaphore(1);

    public int get() {
        try {
            semaphoreCon.acquire();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Get " + n);
        semaphorePro.release();
        return n;
    }

    public void put (int n) {
        try {
            semaphorePro.acquire();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.n = n;
        print("Put " + n);
        semaphoreCon.release();
    }
}
