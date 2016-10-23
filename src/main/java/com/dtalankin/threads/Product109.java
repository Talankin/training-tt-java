/**
 *  23.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import static com.dtalankin.Print.*;

public class Product109 {
    private int n;

    public synchronized int get() {
        print("Got n = " + n);
        return n;
    }

    public synchronized void put(int n) {
        this.n = n;
        print("Put n = " + n);
    }
}
