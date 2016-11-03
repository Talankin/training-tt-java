/**
 *  01.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Semaphore;

public class Producer112 implements Runnable {
    Product112 product = new Product112();

    public Producer112(Product112 product) {
        this.product = product;
        new Thread(this, "Producer Thread").start();
    }

    @Override
    public void run() {
        int n = 0;
        while (true) {
            product.put(n++);
        }
    }
}
