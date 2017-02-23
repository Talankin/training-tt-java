/**
 *  20.02.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;



public class ProducerTask812 {
    private ConcurrentHashMapTask812 map;
    private String name;
    public Thread t;

    public ProducerTask812(ConcurrentHashMapTask812 map, String name) {
        this.map = map;
        this.name = name;
        t = new Thread(runnable);
        t.start();
        System.out.println("Thread " + name + " started...");
    }

    private Runnable runnable = ()-> {
        for (int i = 0; i < 100; i++) {
            map.put(String.valueOf(i), name);
        }
    };

}
