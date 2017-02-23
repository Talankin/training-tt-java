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
        System.out.println("Put LOCKED : " + value);
        try {
            map.put(key, value);
            System.out.println("   Put : " + key + " " + value);
        } finally {
            System.out.println("Put UNLOCKED : " + value);
            lock.writeLock().unlock();
        }
    }

    public void get(String key, String name) {
        lock.readLock().lock();
        System.out.println("Get LOCKED : " + name);
        try {
            System.out.println("   Get : " + key + " " + map.get(key));
        } finally {
            System.out.println("Get UNLOCKED : " + name);
            lock.readLock().unlock();
        }
    }

}