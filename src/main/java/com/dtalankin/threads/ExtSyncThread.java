/**
 *  30.05.2016
 *  Dmitry Talankin
 */


package com.dtalankin.threads;

import java.util.List;

public class ExtSyncThread implements Runnable {
    private static final int ADD = 1;
    private static final int DELETE = 2;
    private int arrayOperation = 0;
    private List<Integer> array;
    public Thread thread;

    public ExtSyncThread(List<Integer> array, int arrayOperation) {
        this.array = array;
        thread = new Thread(this);
        this.arrayOperation = arrayOperation;
        System.out.println("Child thread : " + thread);
        thread.start();
    }

    public void run() {
        if (arrayOperation == ADD) {
            addInArray();
        } else if (arrayOperation == DELETE) {
            deleteFromArray();
        } else {
            System.out.println("There are not actions on array");
        }
        System.out.println("Exiting child thread");
    }

    private synchronized void addInArray() {
        for (int i=0; i<10000; i++) {
            int num = (int)(Math.random()*10000);
            array.add(num);
                System.out.println("num = " + num + " array size = " + array.size());
        }
    }

    private synchronized void deleteFromArray() {
        for (int i=0; i<10000; i++) {
            int num = (int)(Math.random()*array.size());
            System.out.println("----------- num = " + num + " array size = " + array.size());
            array.remove(num);

        }
    }
}
