/**
 *  12.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import static com.dtalankin.Print.print;

public class Thread114 {
    private CyclicBarrier barrier;
    private String name;
    private int time;
    public Thread t;


    public Thread114(CyclicBarrier barrier, String name, int time) {
        this.barrier = barrier;
        this.name = name;
        this.time = time;

        t = new Thread(runnable, name);
        t.start();
    }

    private Runnable runnable = () -> {
        try {
            Thread.sleep(time);
            print(t);
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    };
}
