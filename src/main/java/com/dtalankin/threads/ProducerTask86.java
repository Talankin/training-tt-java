/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class ProducerTask86 extends Thread {
    private ProductTask86 product;

    public ProducerTask86(ProductTask86 product) {
        super("Thread for adding");
        this.product = product;
        this.start();
    }

    @Override
    public void run() {
        for(int i=0; i<10000; i++) {
            product.add();
        }
    }
}
