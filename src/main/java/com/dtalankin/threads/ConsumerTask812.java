/**
 *  23.02.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;



public class ConsumerTask812 {
    private ConcurrentHashMapTask812 map = new ConcurrentHashMapTask812();
    private String name;
    public Thread t;

    public ConsumerTask812(ConcurrentHashMapTask812 map, String name) {
        this.map = map;
        this.name = name;
        t = new Thread(runnable, name);
        t.start();
    }

    private Runnable runnable = ()-> {
        for (int i = 0; i < 100; i++) {
            map.get(String.valueOf(i), name);
        }
    };

}
