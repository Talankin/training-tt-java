/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class ConsumerExtThread extends Thread {
    private ProductExtThread prod;

    public ConsumerExtThread(ProductExtThread prod) {
        super("Consumer Thread");
        this.prod = prod;
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            prod.get();
        }
    }
}
