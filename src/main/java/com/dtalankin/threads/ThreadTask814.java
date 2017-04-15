/**
 *  08.04.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;


public class ThreadTask814 implements Runnable {
    private TransportTask814 transport;
    private MessageTask814 message;

    public ThreadTask814(TransportTask814 transport, MessageTask814 message) {
        this.transport = transport;
        this.message = message;

        new Thread(this);
    }

    @Override
    public void run() {
        transport.sendToSmtpSSL(message);
//        transport.sendToFile(message);
    }
}
