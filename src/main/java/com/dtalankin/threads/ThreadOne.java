/**
 *  07.05.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class ThreadOne implements Runnable {
    public Thread thread;

    public ThreadOne() {
        thread = new Thread(this);
        System.out.println("Child thread One: " + thread);
        thread.start();
    }

    public void run() {
        try {
            for (int i=0; i<5; i++) {
                System.out.println("Child thread One: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread One interrupted ");
        }
        System.out.println("Exiting thread One");
    }
}
