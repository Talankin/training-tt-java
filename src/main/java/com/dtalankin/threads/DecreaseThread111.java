/**
 *  30.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Semaphore;
import static com.dtalankin.Print.print;

public class DecreaseThread111 implements Runnable {
    Semaphore semaphore;
    String name;

    public DecreaseThread111(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
        new Thread(this, "Decrease Thread").start();
    }

    @Override
    public void run() {
        try {
            print(name + " is waiting for access to semaphore");
            semaphore.acquire();
            print(name + " access to semaphore has been got");

            for(int i=0; i<5; i++) {
                Shared.count--;
                print(name + " shared.count = " + Shared.count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            print("InterruptedException caught");
        }

        print(name + " releases the semaphore");
        semaphore.release();
    }
}
