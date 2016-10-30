/**
 *  30.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Semaphore;

import static com.dtalankin.Print.print;

public class IncreaseThread111 implements Runnable {
    Semaphore semaphore;
    String name;

    public IncreaseThread111(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
        new Thread(this, "Increase Thread").start();
    }

    @Override
    public void run() {
        try {
            print(name + " is waiting for access to semaphore");
            semaphore.acquire();
            print(name + " access to semaphore has been got");
            for(int i=0; i<5; i++) {
                Shared.count++;
                print(name + " Shared.count = " + Shared.count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            print("InterruptedException caught");
        }

        print(name + " releases the semaphore");
        semaphore.release();
    }
}
