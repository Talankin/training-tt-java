package com.dtalankin.figures;

import com.dtalankin.Color;

/**
 * 28.09.2015
 * Dmitry Talankin
 * Lessons #2 Task #10
 */

public class CircleFactory {
    private static int countCircles;

    public static Circle createCircle(int x0, int y0, int r, Color color) {
        Circle circle = new Circle(x0, y0, r, color);
        countCircles++;
        return circle;
    }

    public static int getCountCircles() {
        return countCircles;
    }
}
