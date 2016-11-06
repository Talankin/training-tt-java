/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.List;

import static com.dtalankin.Print.print;

public class ThreadTask85 extends Thread {
    private static final String THREAD_FOR_REMOVE = "REMOVE";
    private static final String THREAD_FOR_ADD = "ADD";

    private List<Integer> array;
    private String name;
    private String type;

    public ThreadTask85(List<Integer> array, String name, String type) {
        super(name);
        this.name = name;
        this.type = type;
        this.array = array;
        this.start();
    }

    @Override
    public void run() {
        int n = 10000;
        if(type.equals(THREAD_FOR_ADD)) {
            for(int i=0; i<n; i++) {
                add((int) (Math.random() * n));
            }
        }

        if(type.equals(THREAD_FOR_REMOVE)) {
            for(int i=0; i<n; i++) {
                remove();
            }
        }
    }

    private synchronized void remove() {
        int index = (int) (Math.random() * array.size());
        if (array.size()>0) {
            array.remove(index);
            print("Removed index = " + index + "; size = " + array.size());
        }
    }

    private synchronized void add(int n) {
        array.add(n);
        print("Added number; size = " + array.size());
    }

}
