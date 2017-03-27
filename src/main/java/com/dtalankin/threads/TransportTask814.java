/**
 *  26.03.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.io.File;

public class TransportTask814 {
    private File addresses = new File("src/test/resources/com/dtalankin/Lesson8/addresses.txt");
    public void send (MessageTask814 message) {
        System.out.println("message has been sent");
        System.out.println("file exists " + addresses.exists());

    }
}
