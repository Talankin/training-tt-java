/**
 *  01.06.2016
 *  Dmitry Talankin
 *
 */

package com.dtalankin.threads;

public class MessageForSemaphore {
    public void putMessage(String message) {
        System.out.print(message);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
