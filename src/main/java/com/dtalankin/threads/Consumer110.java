/**
 *  30.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class Consumer110 implements Runnable {
    private Product110 product;

    public Consumer110(Product110 product) {
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
