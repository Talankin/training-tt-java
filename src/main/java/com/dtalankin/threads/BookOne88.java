/**
 *  19.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import static com.dtalankin.Print.print;

public class BookOne88 extends Thread{
    private int n;

    public void read() {
        print("read " + n);
    }

    public void write(int n) {
        this.n = n;
        print("write " + n);
    }
}
