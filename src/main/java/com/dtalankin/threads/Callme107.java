/**
 *  22.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import static com.dtalankin.Print.print;

public class Callme107 {

    public void call(String msg) {
        print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            print("Callme Interrupted");
        }
        print("]");
    }
}
