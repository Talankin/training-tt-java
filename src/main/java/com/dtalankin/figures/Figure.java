package com.dtalankin.figures;

import com.dtalankin.Color;
import com.dtalankin.Colored;
import com.dtalankin.exceptions.ColorException;

import java.io.Serializable;

/**
 * 04.10.2015
 * Dmitry Talankin
 * Lessons #3 Task #9
 */
public abstract class Figure implements Colored, Square, Serializable {
    private int x1, y1;
    private Color color;

    public Figure(int x1, int y1, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
    }

    public Figure(int x1, int y1, String color) throws ColorException {
        this.x1 = x1;
        this.y1 = y1;
        this.color = Color.colorStr(color);
    }

    public void move(int dX, int dY) {
        x1 += dX;
        y1 += dY;
    }

    abstract public void print();
        //System.out.println("Coordinates of figure (" + getX1() + ", " + getY1() + "); ");

    abstract public double square();
    abstract public boolean isPointInside(int x, int y);
    abstract public boolean isPointInside(Point2D p);


    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

}
