/**
 *  12.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.CyclicBarrier;

import static com.dtalankin.Print.print;

public class ThreadBarAction114 implements Runnable {
    @Override
    public void run() {
        print("Barrier reached");
    }
}
