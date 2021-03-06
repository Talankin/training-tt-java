/**
 *  08.05.2016
 *  Dmitry Talankin
 */


package com.dtalankin.threads;

import java.util.List;

public class ThreadOneForSynch implements Runnable {
    public Thread thread;
    private List<Integer> array;

    public ThreadOneForSynch(List<Integer> array) {
        this.array = array;
        thread = new Thread(this);
        System.out.println("Child thread One: " + thread);
        thread.start();
    }

    public void run() {
        for (int i=0; i<10000; i++) {
            int num = (int)(Math.random()*10000);
            synchronized (array) {
                array.add(num);
            }
        }
        System.out.println("Exiting thread One");
    }
}
