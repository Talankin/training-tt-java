/**
 *  15.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import static com.dtalankin.Print.*;

public class Thread102 implements Runnable {

    public Thread102() {
        Thread t = new Thread(this, "Child Thread");
        print(t.getName() + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for(int i=1; i < 6; i++) {
                print("Child Thread " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            print("Child thread interrupted");
        }
        print("Exiting child thread");
    }
}
