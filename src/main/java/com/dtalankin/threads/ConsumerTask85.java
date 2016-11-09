/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class ConsumerTask85 extends Thread {
    private ProductTask85 product;

    public ConsumerTask85(ProductTask85 product) {
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
