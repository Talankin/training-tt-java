/**
 *  09.02.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class PongThreadTask811 implements Runnable{
    private PingPongBufferTask811 buffer;
    public Thread t;

    public PongThreadTask811(PingPongBufferTask811 buffer) {
        this.buffer = buffer;
        t = new Thread(this, "PongThread");
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                buffer.pong(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}