/**
 *  18.12.2016
 *  Dmitry Talankin
 */


package com.dtalankin.threads;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class RemoverTask810 {
    private Lock lock;
    private List<Integer> array;
    private String name;
    public Thread t;

    public RemoverTask810(Lock lock, List<Integer> array, String name) {
        this.lock = lock;
        this.array = array;
        this.name = name;

        t = new Thread(runnable, name);
        t.start();
    }

    private Runnable runnable = () -> {
        int n = 10000;
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                int num = (int) (Math.random() * array.size());
                if (array.size() > 0) {
                    array.remove(num);
                }
                System.out.println("Removed : " + num + " size : " + array.size());
            } finally {
                lock.unlock();
            }
        }
    };
}
