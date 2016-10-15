/**
 *  15.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import static com.dtalankin.Print.print;

public class Thread106 implements Runnable {
    private String name;
    private Thread t;

    public Thread106(String name) {
        this.name = name;
        t = new Thread(this, name);
        print(t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 6; i++) {
                print(name + " n = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            print(name + " interrupted");
        }
        print("Exiting " + name);
    }

    public Thread getT() {
        return t;
    }
}
