/**
 *  04.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class ProducerSemLamb {
    private ProductSemLamb prod;
    public Thread t;

    public ProducerSemLamb(ProductSemLamb prod) {
        this.prod = prod;
        t = new Thread(runnable, "Producer Thread");
        t.start();
    }

    Runnable runnable = () -> {
        int n = 0;
            while (true) {
                prod.put(n++);
            }
    };
}
