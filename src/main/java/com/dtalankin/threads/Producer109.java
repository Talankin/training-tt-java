/**
 *  23.10.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import static com.dtalankin.Print.*;

public class Producer109 implements Runnable {
    private Product109 product;

    public Producer109(Product109 product) {
        this.product = product;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            product.put(i++);
        }
    }
}
