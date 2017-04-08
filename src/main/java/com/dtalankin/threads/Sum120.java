/**
 *  02.04.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Callable;

public class Sum120 implements Callable<Integer> {
    private int max;

    public Sum120(int max) {
        this.max = max;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 1;
        for (int i = 2; i <= max; i++) {
            sum += i;
        }
        return sum;
    }
}
