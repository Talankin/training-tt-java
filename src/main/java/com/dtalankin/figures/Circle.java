package com.dtalankin.figures;

import com.dtalankin.Color;
import com.dtalankin.Main;
import com.dtalankin.exceptions.ColorException;

/**
 * 27.09.2015
 * Dmitry Talankin
 * Lessons #2 Task #9
 */
public class Circle extends Figure {
    private final static double EPS = 0.01;
    private int r;

    public Circle(int x1, int y1, int r, Color color) {
        super(x1, y1, color);
        this.r = r;

    }

    public Circle(int x1, int y1, int r, String color) throws ColorException {
        super(x1, y1, Color.colorStr(color));
        this.r = r;

    }

    @Override
    public void print() {
        System.out.println("Center of circle (" + getX1() + ", " + getY1() + "); " +
                " radius = " + r + ";  color = " + super.getColor());
    }

    @Override
    public double square() {
        return Math.PI * Math.pow(r,2);
    }

    public double circuit() {
        return 2 * Math.PI * r;
    }

    public boolean isPointInside(int xP, int yP) {
        return (r - Main.distanceBetweenPoints(getX1(), getY1(), xP, yP)) > 0;
    }

    public boolean isPointInside(Point2D point) {
        return (r - Main.distanceBetweenPoints(getX1(), getY1(),point.getX(),point.getY())) > 0;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (getX1() != circle.getX1()) return false;
        if (getY1() != circle.getY1()) return false;
        return getR() == circle.getR();

    }

    @Override
    public int hashCode() {
        int result = getX1();
        result = 31 * result + getY1();
        result = 31 * result + getR();
        return result;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x1=" + getX1() +
                ", y1=" + getY1() +
                ", r=" + r +
                '}';
    }
}
