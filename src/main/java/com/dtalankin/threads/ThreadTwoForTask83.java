/**
 *  22.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import static com.dtalankin.Print.print;

public class ThreadTwoForTask83 extends Thread {

    public ThreadTwoForTask83() {
        super("Thread 2");
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
