/**
 *  08.05.2016
 *  Dmitry Talankin
 *
 *  class for exercise 107-SynchDemo
 */

package com.dtalankin.threads;

public class Caller implements Runnable {
    private String message;
    private Callme callme;
    public Thread thread;

    public Caller(Callme callme, String message) {
        this.callme = callme;
        this.message = message;
        thread = new Thread(this, "I'm Caller thread");
        System.out.println(thread);
        thread.start();
    }

    @Override
    public void run() {
        // this is critical section.
        // should be synchronised
        callme.putMessage(message);
        System.out.println("Exiting thread Caller");
    }
}
