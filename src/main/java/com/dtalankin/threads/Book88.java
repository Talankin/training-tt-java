/**
 *  11.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Semaphore;
import static com.dtalankin.Print.*;

public class Book88 {
    private int n;
    private Semaphore semWr = new Semaphore(1);
    private Semaphore semRdr = new Semaphore(0);

    public void write(int n) {
        try {
            semWr.acquire();
            this.n = n;
            print("Writer " + n);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semRdr.release();
    }

    public void read() {
        try {
            semRdr.acquire();
            print("Reader " + n);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semWr.release();
    }
}
