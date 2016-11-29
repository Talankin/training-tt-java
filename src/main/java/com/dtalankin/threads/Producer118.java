/**
 *  27.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class Producer118 extends Thread {
    private Buffer118 buffer;

    public Producer118(Buffer118 buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            buffer.put(i);
        }
    }
}

