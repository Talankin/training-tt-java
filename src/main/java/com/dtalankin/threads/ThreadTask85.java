/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.List;

public class ThreadTask85 extends Thread {
    private static final String THREAD_FOR_REMOVE = "REMOVE";
    private static final String THREAD_FOR_ADD = "ADD";

    private ProductTask85 prod;
    private String name;
    private String type;

    public ThreadTask85(String name, String type, ProductTask85 prod) {
        super(name);
        this.name = name;
        this.type = type;
        this.prod = prod;
        this.start();
    }

    @Override
    public void run() {
        int n = 10000;
        if(type.equals(THREAD_FOR_ADD)) {
            for(int i=0; i<n; i++) {
                prod.add((int) (Math.random() * n));
            }
        }

        if(type.equals(THREAD_FOR_REMOVE)) {
            for(int i=0; i<n; i++) {
                prod.remove();
            }
        }
    }
}
