/**
 *  12.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.CountDownLatch;

import static com.dtalankin.Print.print;

public class ThreadOne113 extends Thread {
    private CountDownLatch latch;

    public ThreadOne113(CountDownLatch latch) {
        super("Thread 1");
        this.latch = latch;
        this.start();
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            print("Thread 1 i = " + i);
            latch.countDown();
        }
    }
}
