/**
 *  01.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Semaphore;

public class Consumer112 implements Runnable {
    Product112 product = new Product112();

    public Consumer112(Product112 product) {
        this.product = product;
        new Thread(this, "Consumer Thread").start();
    }

    @Override
    public void run() {
        while (true) {
            product.get();
        }
    }
}
