/**
 *  22.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import static com.dtalankin.Print.print;

public class ThreadOneForTask83 extends Thread {

    public ThreadOneForTask83() {
        super("Thread 1");
        print(this);
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 6; i++) {
                print(this.getName() + " n = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            print(this.getName() + " interrupted");
        }
        print("Exiting " + this.getName());
    }
}
