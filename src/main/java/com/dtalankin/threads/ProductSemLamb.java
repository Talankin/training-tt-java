/**
 *  04.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Semaphore;

import static com.dtalankin.Print.print;

public class ProductSemLamb {
    private int n;
    private Semaphore semCon = new Semaphore(0);
    private Semaphore semPro = new Semaphore(1);

    public void get() {
        try {
            semCon.acquire();
            print("Got " + n);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semPro.release();
    }

    public void put(int n) {
        try {
            semPro.acquire();
            this.n = n;
            print("Put" + n);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semCon.release();
    }

}
