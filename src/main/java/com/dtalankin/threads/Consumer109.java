/**
 *  23.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import static com.dtalankin.Print.*;

public class Consumer109 implements Runnable {
    private Product109 product;

    public Consumer109(Product109 product) {
        this.product = product;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            product.get();
        }
    }
}
