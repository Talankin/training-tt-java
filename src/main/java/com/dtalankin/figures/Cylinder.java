package com.dtalankin.figures;

import com.dtalankin.Color;
import com.dtalankin.exceptions.ColorException;
import com.dtalankin.figures.Point3D;

/**
 * 04.10.2015
 * Dmitry Talankin
 * Lessons #3 Task #8
 */
public class Cylinder extends Circle {
    private int height;

    public Cylinder(int x0, int y0, int r, int height, Color color) {
        super(x0, y0, r, color);
        this.height = height;
    }

    public Cylinder(int x0, int y0, int r, int height, String color) throws ColorException {
        super(x0, y0, r, Color.colorStr(color));
        this.height = height;
    }

    @Override
    public void print() {
        System.out.println("Center of cylinder (" + getX1() + ", " + getY1() + "); " +
                " radius = " + getR() + "; height = " + height + "; color = " + super.getColor());
    }

    @Override
    public void move(int dX, int dY) {
        super.move(dX, dY);
    }

    @Override
    public double square() {
        return super.square();
    }

    public double volume() {
        return super.square() * height;
    }

    public double squareSide() {
        return super.circuit() * height;
    }

    public boolean isPointInside(int xP, int yP, int pZ) {
        return super.isPointInside(xP, yP) &&
                pZ > 0 &&
                pZ < height;
    }

    public boolean isPointInside(Point3D point) {
        return super.isPointInside(point.getX(), point.getY()) &&
                point.getZ() > 0 &&
                point.getZ() < height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cylinder cylinder = (Cylinder) o;

        return getHeight() == cylinder.getHeight();

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getHeight();
        return result;
    }

    @Override
    public String toString() {
        return "Center of cylinder (" + getX1() + ", " + getY1() + "); " +
                " radius = " + getR() + "; height = " + height + "; color = " + super.getColor();
    }
}
