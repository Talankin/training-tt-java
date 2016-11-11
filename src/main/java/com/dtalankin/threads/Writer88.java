/**
 *  11.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class Writer88 extends Thread {
    private Book88 book;

    public Writer88(Book88 book) {
        super("Writer Thread");
        this.book = book;
        this.start();
    }

    @Override
    public void run() {
        int n = 1;
        while (true) {
            book.write(n++);
        }
    }
}
