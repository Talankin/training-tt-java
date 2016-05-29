package com.dtalankin.figures;

import com.dtalankin.Color;
import com.dtalankin.exceptions.ColorException;

/**
 * 04.10.2015
 * Dmitry Talankin
 * Lessons #3 Task #6
 */
public class Rectangle3D extends Rectangle{
    private int height;

    public Rectangle3D(int x1, int y1, int x2, int y2, int height, Color color) {
        super(x1, y1, x2, y2, color);
        this.height = height;
    }

    public Rectangle3D(int length, int width, int height, Color color) {
        super(length, width, color);
        this.height = height;
    }

    public Rectangle3D(Color color) {
        super(color);
        height = 1;
    }

    public Rectangle3D(String color) throws ColorException {
        super(color);
        height = 1;
    }

    @Override
    public void move(int dX, int dY) {
        super.move(dX, dY);
    }

    @Override
    public void decreaseRectangle(int nX, int nY) {
        int y1, x2;
        nX = (nX == 0) ? 1:nX;
        nY = (nY == 0) ? 1:nY;

        x2 = getX1() + (getX2() - getX1()) / nX;
        y1 = getY2() - (getY2() - getY1()) / nY;

        setX2(x2);
        setY1(y1);
    }

    @Override
    public double square() {
        return super.square();
    }

    /*private double volume() {
        return super.square() * height;
    }*/

    public boolean isPointInside3D(int pX, int pY, int pZ) {
        return super.isPointInside(pX, pY) &&
                pZ > 0 &&
                pZ < height;
    }

    public boolean isPointInside3D(Point3D point) {
        return isPointInside3D(point.getX(), point.getY(), point.getZ());
    }

    @Override
    public boolean isCrossRectangles(Rectangle rect) {
        return super.isCrossRectangles(rect);
    }

    public boolean isRectangleInside(Rectangle3D rect) {
        return super.isRectangleInside(rect) &&
                rect.getHeight() > height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Rectangle3D{" +
                "x1=" + getX1() +
                ", y1=" + getY1() +
                ", x2=" + getX2() +
                ", y2=" + getY2() +
                ", height=" + height +
                '}' + ";  color = " + super.getColor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Rectangle3D that = (Rectangle3D) o;

        return getHeight() == that.getHeight();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getHeight();
        return result;
    }
}
