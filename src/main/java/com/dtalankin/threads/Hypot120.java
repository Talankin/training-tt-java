/**
 *  02.04.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Callable;

public class Hypot120 implements Callable<Double> {
    private int side1;
    private int side2;

    public Hypot120(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public Double call() throws Exception {
        Double hypot;
        hypot = Math.sqrt((side1*side1)+(side2*side2));
        Thread.sleep(5000);
        return hypot;
    }
}
