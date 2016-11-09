/**
 *  09.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Semaphore;
import static com.dtalankin.Print.print;

public class PingPong87 {
    private Semaphore semPing = new Semaphore(1);
    private Semaphore semPong = new Semaphore(0);

    public void sayPing() {
        try {
            semPing.acquire();
            print("Ping");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            print("Caught exception in sayPing method");
        }
        semPong.release();
    }

    public void sayPong() {
        try {
            semPong.acquire();
            print("Pong");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            print("Caught exception in sayPong method");
        }
        semPing.release();
    }
}
