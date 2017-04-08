/**
 *  02.04.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Callable;

public class Factorial120 implements Callable<Integer> {
    private int max;

    public Factorial120(int max) {
        this.max = max;
    }

    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 2; i <= max; i++) {
//            Thread.sleep(5000);
            fact *= i;
        }
        return fact;
    }
}
