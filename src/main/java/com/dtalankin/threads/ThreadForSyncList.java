/**
 *  31.05.2016
 *  Dmitry Talankin
 */


package com.dtalankin.threads;

import java.util.List;

public class ThreadForSyncList implements Runnable {
    private static final int ADD = 1;
    private static final int DELETE = 2;
    private int arrayOperation = 0;
    private List<Integer> array;
    public Thread thread;

    public ThreadForSyncList(List<Integer> array, int arrayOperation, String name) {
        this.array = array;
        thread = new Thread(this, name);
        this.arrayOperation = arrayOperation;
        System.out.println("Child thread : " + thread);
        thread.start();
    }

    public void run() {
        if (arrayOperation == ADD) {
            for (int i=0; i<10000; i++) {
                addInArray();
            }
        } else if (arrayOperation == DELETE) {
            for (int i=0; i<10000; i++) {
                deleteFromArray();
            }
        } else {
            System.out.println("There are not actions on array");
        }
        System.out.println("Exiting child thread, " + thread);
    }

    private void addInArray() {
        int num = (int)(Math.random()*10000);
        array.add(num);
//        System.out.println("num = " + num + " array size = " + array.size());
    }

    private void deleteFromArray() {
        int num = (int)(Math.random()*array.size());
//        System.out.println("----------- num = " + num + " array size = " + array.size());
        if (array.size() > 0) {
            array.remove(num);
        }
    }
}
