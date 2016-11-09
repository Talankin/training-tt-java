/**
 *  09.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class PongThread87 {
    private PingPong87 pingPong;
    public Thread t;

    public PongThread87(PingPong87 pingPong) {
        this.pingPong = pingPong;
        t = new Thread(runnable, "Pong Thread");
        t.start();
    }

    private Runnable runnable = () -> {
        while (true) {
            pingPong.sayPong();
        }
    };
}
