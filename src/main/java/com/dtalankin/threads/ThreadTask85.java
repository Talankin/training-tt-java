/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.List;

public class ThreadTask85 extends Thread {
    List<Integer> array;
    String name;

    public ThreadTask85(List<Integer> array, String name) {
        super(name);
        this.array = array;
        this.name = name;
        this.start();
    }

    @Override
    public void run() {

    }
}
