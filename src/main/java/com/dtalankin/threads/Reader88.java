/**
 *  11.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class Reader88 extends Thread {
    private Book88 book;

    public Reader88(Book88 book) {
        super("Reader Thread");
        this.book = book;
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            book.read();
        }
    }
}
