package com.dtalankin.figures;

import com.dtalankin.Color;
import com.dtalankin.exceptions.ColorException;

/**
 * 29.09.2015
 * Dmitry Talankin
 * Lesson #3
 */
public class Point3D extends Point2D {
    private int z;

    public Point3D(Color color) {
        super(color);
        z = 10;
    }

    public Point3D(String color) throws ColorException {
        super(color);
        z = 10;
    }

    public Point3D(int x, int y, int z, Color color) {
        super(x, y, color);
        this.z = z;
    }

    public void moveTo(int x, int y, int z) {
        super.moveTo(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public void print() {
        System.out.println("Point3D: x = " + getX() + "; y = " + getY() + ";  color = " + getColor());
    }
}
