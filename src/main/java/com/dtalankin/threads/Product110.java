/**
 *  30.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import static com.dtalankin.Print.print;

public class Product110 {
    private int n;
    private boolean valueSet = false;

    public synchronized int get() {
        if(!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                print("InterruptedException caught");
            }
        }
        print("Get n = " + n);
        valueSet = false;
        notify();
        return n;
    }

    public synchronized void put(int n) {
        if(valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                print("InterruptedException caught");
            }
        }
        this.n = n;
        print("Put n = " + this.n);
        valueSet = true;
//        notify();
    }
}
