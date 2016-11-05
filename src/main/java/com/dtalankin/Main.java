/**
 *  15.09.2015
 *  Dmitry Talankin
 */

package com.dtalankin;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import com.dtalankin.figures.*;
import com.dtalankin.threads.ConsumerTask84;
import com.dtalankin.threads.ProducerTask84;

import static com.dtalankin.Print.print;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        ProducerTask84 prod = new ProducerTask84(array);
        ConsumerTask84 cons = new ConsumerTask84(array);
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
