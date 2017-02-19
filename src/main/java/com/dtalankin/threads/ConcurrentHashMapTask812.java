/**
 *  13.02.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentHashMapTask812 {
    private Map<String, String> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, String value) {
        lock.writeLock().lock();
        try {
            map.put(key, value);
            System.out.println("Put : " + key + " " + value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println("Put : " + key + " " + map.get(key));
        } finally {
            lock.readLock().unlock();
        }
    }

}