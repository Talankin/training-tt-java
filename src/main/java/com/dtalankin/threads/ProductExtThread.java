/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Semaphore;

import static com.dtalankin.Print.print;

public class ProductExtThread {
    private int n;
    private Semaphore semCons = new Semaphore(0);
    private Semaphore semProd = new Semaphore(1);

    public void get() {
        try {
            semCons.acquire();
            print("Got " + n);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semProd.release();
    }

    public void put(int n) {
        try {
            semProd.acquire();
            this.n = n;
            print("Put " + n);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semCons.release();
    }
}
