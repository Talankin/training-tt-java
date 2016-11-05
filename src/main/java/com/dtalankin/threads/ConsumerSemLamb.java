/**
 *  04.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class ConsumerSemLamb {
    private ProductSemLamb prod;
    public Thread t;

    public ConsumerSemLamb(ProductSemLamb prod) {
        this.prod = prod;
        t = new Thread(runnable, "Consumer Thread");
        t.start();
    }

    private Runnable runnable = () -> {
        while (true) {
            prod.get();
        }
    };
}
