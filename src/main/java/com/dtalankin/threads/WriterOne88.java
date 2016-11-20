/**
 *  19.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.locks.ReadWriteLock;

public class WriterOne88 extends Thread{
    private BookOne88 book;
    private ReadWriteLock lock;

    public WriterOne88(BookOne88 book, ReadWriteLock lock) {
        super();
        this.book = book;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        int n = 0;
        while (true) {
            try {
                lock.writeLock().lock();
                book.write(n++);
            } finally {
                lock.writeLock().unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
