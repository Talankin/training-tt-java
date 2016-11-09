/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class ConsumerTask86 extends Thread {
    private ProductTask86 product;

    public ConsumerTask86(ProductTask86 product) {
        super("Thread for removing");
        this.product = product;
        this.start();
    }

    @Override
    public void run() {
        for(int i=0; i<10000; i++) {
            product.remove();
        }
    }
}
