/**
 *  12.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.CountDownLatch;

import static com.dtalankin.Print.print;

public class ThreadTwo113 extends Thread {
    private CountDownLatch latch;

    public ThreadTwo113(CountDownLatch latch) {
        super("Thread 2");
        this.latch = latch;
        this.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i=0; i<10; i++) {
            print("Thread 2 i = " + i);
            latch.countDown();
        }
    }
}
