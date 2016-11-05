/**
 *  15.09.2015
 *  Dmitry Talankin
 */

package com.dtalankin;

import java.util.concurrent.Semaphore;

import com.dtalankin.figures.*;
import com.dtalankin.threads.ConsumerSemLamb;
import com.dtalankin.threads.ProducerSemLamb;
import com.dtalankin.threads.ProductSemLamb;

import static com.dtalankin.Print.print;

public class Main {
    public static void main(String[] args) {
        ProductSemLamb product = new ProductSemLamb();
        ProducerSemLamb producer = new ProducerSemLamb(product);
        ConsumerSemLamb consumer = new ConsumerSemLamb(product);

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
