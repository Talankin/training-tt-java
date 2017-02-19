/**
 *  20.02.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;



public class ProducerTask812 {
    private ConcurrentHashMapTask812 map;
    public Thread t;

    public ProducerTask812(ConcurrentHashMapTask812 map) {
        this.map = map;
        t = new Thread(runnable);
        t.start();
    }

    private Runnable runnable = ()-> {
        for (int i = 0; i < 100; i++) {
            map.put(String.valueOf(i),String.valueOf(i));
        }
    };

}
