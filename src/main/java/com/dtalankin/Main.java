/**
 *  15.09.2015
 *  Dmitry Talankin
 */

package com.dtalankin;

import com.dtalankin.figures.*;
import com.dtalankin.threads.Consumer109;
import com.dtalankin.threads.Producer109;
import com.dtalankin.threads.Product109;

import static com.dtalankin.Print.print;

public class Main {
    public static void main(String[] args) {
        Product109 product = new Product109();
        Producer109 producer = new Producer109(product);
        Consumer109 consumer109 = new Consumer109(product);

        print("Type Ctrl+C to stop programm");
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
