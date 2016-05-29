/**
 *  07.05.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class ThreadThree implements Runnable {
    public Thread thread;

    public ThreadThree() {
        thread = new Thread(this);
        System.out.println("Child thread Three: " + thread);
        thread.start();
    }

    public void run() {
        try {
            for (int i=0; i<5; i++) {
                System.out.println("Child thread Three: " + i);
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread Three interrupted ");
        }
        System.out.println("Exiting thread Three");
    }
}
