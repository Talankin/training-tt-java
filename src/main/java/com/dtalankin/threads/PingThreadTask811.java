/**
 *  09.02.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class PingThreadTask811 implements Runnable{
    private PingPongBufferTask811 buffer;
    public Thread t;

    public PingThreadTask811(PingPongBufferTask811 buffer) {
        this.buffer = buffer;
        t = new Thread(this, "PingThread");
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                buffer.ping(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}