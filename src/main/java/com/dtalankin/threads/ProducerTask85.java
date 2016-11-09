/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class ProducerTask85 extends Thread {
    private ProductTask85 product;

    public ProducerTask85(ProductTask85 product) {
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
