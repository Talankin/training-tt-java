/**
 *  09.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class PingThread87 {
    private PingPong87 pingPong = new PingPong87();
    public Thread t;

    public PingThread87(PingPong87 pingPong) {
        this.pingPong = pingPong;
        t = new Thread(runnable, "Ping Thread");
        t.start();
    }

    private Runnable runnable = () -> {
        while (true) {
            pingPong.sayPing();
        }
    };
}
