/**
 *  15.09.2015
 *  Dmitry Talankin
 */

package com.dtalankin;

import com.dtalankin.figures.*;
import com.dtalankin.threads.Thread106;

import static com.dtalankin.Print.print;

public class Main {
    public static void main(String[] args) {
        Thread106 t1 = new Thread106("Thread 1");
        print("Thread 1 is alive " + t1.getT().isAlive());
        print("Exiting main thread");
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
