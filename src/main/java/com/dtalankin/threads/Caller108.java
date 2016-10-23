/**
 *  22.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class Caller108 extends Thread {
    private Callme107 callme;
    private String msg;

    public Caller108(Callme107 callme, String msg, String tName) {
        super(tName);
        this.callme = callme;
        this.msg = msg;
        start();
    }

    @Override
    public void run() {
        // outer synchronization, because we don't change Callme class
        synchronized (callme) { // synchronized block
            callme.call(msg);
        }
    }
}
