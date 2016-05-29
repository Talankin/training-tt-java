/**
 * 26.09.2015
 * Dmitry Talankin
 * Lessons #2 Task #28
 */

package com.dtalankin.figures;

import com.dtalankin.Color;
import com.dtalankin.exceptions.ColorException;

public class Triangle extends Figure {
    private final static double EPS = 0.01;
    private int x2,y2;
    private int x3,y3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color) {
        super(x1, y1, color);
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, String color) throws ColorException {
        super(x1, y1, Color.colorStr(color));
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public void print() {
        System.out.println("Triangle:   1 point (" + getX1() + ", " + getY1() + "); " +
                " 2 point (" + x2 + ", " + y2 + ");" +
                " 3 point (" + x3 + ", " + y3 + "); color = " + super.getColor());
    }

    @Override
    public void move(int dX, int dY) {
        super.move(dX, dY);
        x2 += dX;
        y2 += dY;
        x3 += dX;
        y3 += dY;
    }

    @Override
    public double square() {
        return Math.abs((float)((getX1()-x3)*(y2-y3)-(x2-x3)*(getY1()-y3))/2f);
    }

    public double square(int x0, int y0, int xA, int yA, int xB, int yB) {
        return Math.abs((float)((x0-xB)*(yA-yB)-(xA-xB)*(y0-yB))/2f);
    }

    public boolean isPointInside(int x0, int y0) {
        double square1 = square(x0, y0, getX1(), getY1(), x2, y2);
        double square2 = square(x0, y0, getX1(), getY1(), x3, y3);
        double square3 = square(x0, y0, x2, y2, x3, y3);

        /*
        int res1 = (x1 - x0) * (y2 - y1) - (x2 - x1) * (y1 - y0);
        int res2 = (x2 - x0) * (y3 - y2) - (x3 - x2) * (y2 - y0);
        int res3 = (x3 - x0) * (y1 - y3) - (x1 - x3) * (y3 - y0);
        return (res1 > 0 && res2 > 0 && res3 > 0) || (res1 < 0 && res2 < 0 && res3 < 0);
        */

        return Math.abs((square1 + square2 + square3) - this.square()) <= EPS;
    }

    public boolean isPointInside(Point2D point) {
        double square1 = square(point.getX(), point.getY(), getX1(), getY1(), x2, y2);
        double square2 = square(point.getX(), point.getY(), getX1(), getY1(), x3, y3);
        double square3 = square(point.getX(), point.getY(), x2, y2, x3, y3);

        return Math.abs((square1 + square2 + square3) - this.square()) <= EPS;
    }

    public boolean isAllSidesEquals() {
        double length1 = Math.sqrt(Math.pow(x2 - getX1(), 2) + Math.pow(y2 - getY1(), 2));
        double length2 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double length3 = Math.sqrt(Math.pow(getX1() - x3, 2) + Math.pow(getY1() - y3, 2));

        return (Math.abs(length1 - length2) <= EPS) &&
                (Math.abs(length1 - length3) <= EPS) &&
                (Math.abs(length2 - length3) <= EPS);
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getX3() {
        return x3;
    }

    public int getY3() {
        return y3;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (getX1() != triangle.getX1()) return false;
        if (getY1() != triangle.getY1()) return false;
        if (getX2() != triangle.getX2()) return false;
        if (getY2() != triangle.getY2()) return false;
        if (getX3() != triangle.getX3()) return false;
        return getY3() == triangle.getY3();

    }

    @Override
    public int hashCode() {
        int result = getX1();
        result = 31 * result + getY1();
        result = 31 * result + getX2();
        result = 31 * result + getY2();
        result = 31 * result + getX3();
        result = 31 * result + getY3();
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "x1=" + getX1() +
                ", y1=" + getY1() +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", x3=" + x3 +
                ", y3=" + y3 +
                '}';
    }
}
