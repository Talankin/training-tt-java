/**
 *  30.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class Producer110 implements Runnable {
    private Product110 product;

    public Producer110(Product110 product) {
        this.product = product;

        new Thread(this, "Producer Thread").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            product.put(i++);
        }
    }
}
