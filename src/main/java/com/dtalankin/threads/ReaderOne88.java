/**
 *  19.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.locks.ReadWriteLock;

public class ReaderOne88 extends Thread{
    private BookOne88 book;
    private ReadWriteLock lock;

    public ReaderOne88(BookOne88 book, ReadWriteLock lock) {
        super();
        this.book = book;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.readLock().lock();
                book.read();
            } finally {
                lock.readLock().unlock();
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
