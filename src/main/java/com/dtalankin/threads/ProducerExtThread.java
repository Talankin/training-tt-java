/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class ProducerExtThread extends Thread {
    private ProductExtThread prod;

    public ProducerExtThread(ProductExtThread prod) {
        super("Producer Thread");
        this.prod = prod;
        this.start();
    }

    @Override
    public void run() {
        int n = 1;
        while (true) {
            prod.put(n++);
        }
    }
}
