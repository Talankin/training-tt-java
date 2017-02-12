/**
 *  29.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class Consumer118 extends Thread {
    private Buffer118 buffer;

    public Consumer118(Buffer118 buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            buffer.take();
        }
    }
}

