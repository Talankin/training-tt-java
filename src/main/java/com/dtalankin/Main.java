/**
 *  15.09.2015
 *  Dmitry Talankin
 */

package com.dtalankin;

import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.dtalankin.figures.*;
import com.dtalankin.threads.ProducerTask85;
import com.dtalankin.threads.ReaderLockThread117;
import com.dtalankin.threads.WriterLockThread117;

public class Main {
    public static void main(String[] args) {

    }

    //рекурсия - факториал
    class fact {
        int calc (int x) {
            if (x == 1) {
                return x;
            } else {
                return x*calc(x-1);
            }

        }
    }

    public static double distanceBetweenPoints(int xA, int yA, int xB, int yB) {
        return Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2));
    }

    static void test(Figure f) {
        f.move(2,2);
    }

}
