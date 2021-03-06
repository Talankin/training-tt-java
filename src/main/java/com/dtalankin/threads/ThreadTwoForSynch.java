/**
 *  08.05.2016
 *  Dmitry Talankin
 */


package com.dtalankin.threads;

import java.util.List;

public class ThreadTwoForSynch implements Runnable {
    public Thread thread;
    private List<Integer> array;

    public ThreadTwoForSynch(List<Integer> array) {
        this.array = array;
        thread = new Thread(this);
        System.out.println("Child thread Two: " + thread);
        thread.start();
    }

    public void run() {
        for (int i=0; i<10000; i++) {
            int num = (int)(Math.random()*array.size());
            synchronized (array) {
                if (array.size() > 0) {
                    array.remove(num);
                }
            }
        }
        System.out.println("Exiting thread Two");
    }

}
