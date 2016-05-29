package com.dtalankin.figures;

import com.dtalankin.Color;
import com.dtalankin.Colored;
import com.dtalankin.exceptions.ColorException;

/**
 * 22.09.2015
 * Dmitry Talankin
 * lesson #2
 */
public class Point2D implements Colored {
    private int x, y;
    private Color color;

    private static int count = 10;

    //инициализатор только статических полей (статический конструктор)
    static {
        count = 200;
    }

    //overload - ниже несколько конструкторов
    public Point2D(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        count++;
    }

    public Point2D(Point2D point, Color color) {
        this(point.x, point.y, color);
    }

    public Point2D(int x, Color color) {
        this(x,0, color);
    }

    public Point2D(Color color) {
        this(0, color);
    }

    public Point2D(String color) throws ColorException {
        this(0, Color.colorStr(color));
    }

    public void print() {
        System.out.println("Point2D: x = " + x + "; y = " + y + ";  color = " + color);
    }

    public static int getCount() {
        return count;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveTo(int dX, int dY) {
        x+=dX;
        y+=dY;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public void moveTo(int dX) {
        moveTo(dX, 0);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //экземпляры классов не могут быть равны - getClass()
        if (o == null || getClass() != o.getClass()) return false;

        Point2D point2D = (Point2D) o;

        if (getX() != point2D.getX()) return false;
        return getY() == point2D.getY();

    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        return result;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
