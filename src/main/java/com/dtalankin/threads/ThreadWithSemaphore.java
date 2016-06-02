/**
 *  01.06.2016
 *  Dmitry Talankin
 */


package com.dtalankin.threads;

import java.util.concurrent.Semaphore;

public class ThreadWithSemaphore implements Runnable {
    private Semaphore semaphore;
    private MessageForSemaphore messageObject;
    private String message;
    public Thread thread;

    public ThreadWithSemaphore(Semaphore semaphore, MessageForSemaphore messageObject, String message) {
        this.semaphore = semaphore;
        this.messageObject = messageObject;
        this.message = message;
        System.out.println("Starting thread : " + message);
        thread = new Thread(this, message);
        thread.start();
    }

    public void run() {
        try {
            semaphore.acquire();

        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted " + message);
        }
//        while(true) {
//            messageObject.putMessage(message);
//            semaphore.release();
//        }

        for(int i=0; i<5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            messageObject.putMessage(message);
            semaphore.release();
        }

    }

}
