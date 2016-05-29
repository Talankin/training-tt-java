/**
 *  08.05.2016
 *  Dmitry Talankin
 *
 *  class for exercise 107-SynchDemo
 */

package com.dtalankin.threads;

public class Callme {
    public void putMessage(String message) {
        System.out.print("[" + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }
}
