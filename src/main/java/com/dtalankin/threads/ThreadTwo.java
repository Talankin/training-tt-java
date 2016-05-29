/**
 *  07.05.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class ThreadTwo implements Runnable {
    public Thread thread;

    public ThreadTwo() {
        thread = new Thread(this);
        System.out.println("Child thread Two: " + thread);
        thread.start();
    }

    public void run() {
        try {
            for (int i=0; i<5; i++) {
                System.out.println("Child thread Two: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread Two interrupted ");
        }
        System.out.println("Exiting thread Two");
    }
}
