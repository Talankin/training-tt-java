/**
 *  22.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import static com.dtalankin.Print.print;

public class Caller107 extends Thread {
    private Callme107 callme;
    private String msg;

    public Caller107(Callme107 callme, String msg, String tName) {
        super(tName);
        this.callme = callme;
        this.msg = msg;
        start();
    }

    @Override
    public void run() {
        callme.call(msg);
    }
}
