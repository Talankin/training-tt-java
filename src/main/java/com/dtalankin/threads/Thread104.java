/**
 *  15.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import static com.dtalankin.Print.print;

public class Thread104 extends Thread {
    private int num;

    public Thread104(int num) {
        super("This is child thread");
        this.num = num;
        print("Child thread starts");
        start();
    }

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 1; i < num; i++) {
                print("Child thread is working " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            print("Child thread interrupted");
        }
        print("Exiting child thread");

    }
}
