/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.List;

import static com.dtalankin.Print.print;

public class ThreadTask86 extends Thread {
    private static final String ADD = "ADD";
    private static final String REMOVE = "REMOVE";
    private List<Integer> array;
    private String name;

    public ThreadTask86(List<Integer> array, String name) {
        super(name);
        this.array = array;
        this.name = name;
        this.start();
    }

    @Override
    public void run() {
        int n = 10000;
        if (name.equals(ADD)) {
            for(int i=0; i<n; i++) {
                add((int)(Math.random() * n));
            }
            print("Exit from adding ==================");
        }

        if (name.equals(REMOVE)) {
            for(int i=0; i<n; i++) {
                if (array.size()>0) {
                    remove((int)(Math.random() * array.size()));
                }
            }
            print("Exit from removing .................");
        }

    }

    private synchronized void add(int n) {
        array.add(n);
        print("Added " + array.size());
    }

    private synchronized void remove(int index) {
        array.remove(index);
        print("Removed " + array.size());
    }
}
