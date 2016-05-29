/**
 * 22.09.2015
 * Dmitry Talankin
 * Lessons #2 Task #7
 */

package com.dtalankin.figures;

import com.dtalankin.Color;
import com.dtalankin.exceptions.ColorException;

import java.io.Serializable;

public class Rectangle extends Figure implements Serializable {
    //private int x1,y1; // 1 вершина - слева внизу
    private int x2,y2; // 2 вершина - справа вверху

    //Конструктор 1
    public Rectangle(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, color);
        //Нормализация прямоугольника
        if (x1 <= x2) {
            this.x2 = x2;
        } else {
            setX1(x2);
            this.x2 = x1;
        }

        if (y1 <= y2) {
            this.y2 = y2;
        } else {
            setY1(y2);
            this.y2 = y1;
        }
    }

    // Конструктор 2
    public Rectangle(int width, int height, Color color) {
        super(0,0,color);
        x2 = width;
        y2 = height;
    }

    // Конструктор 3
    public Rectangle(Color color) {
        this(1,1,color);
    }

    public Rectangle(String color) throws ColorException {
        this(1,1,Color.colorStr(color));
    }

    public Rectangle(int width, int height, String color) throws ColorException {
        super(0,0,color);
        x2 = width;
        y2 = height;
    }

    //метод, печатающий координаты вершин Rectangle;
    @Override
    public void print() {
        System.out.println("Rectangle:  left bottom (" + getX1() + ", " + getY1() + "); right top (" + x2 + ", " + y2 + ")" +
                " left top (" + getX1() + ", " + y2 + "); right bottom (" + x2 + ", " + getY1() + ")" + ";  color = " + super.getColor());
    }



    // метод, уменьшающий стороны Rectangle в (nx,ny) раз
    // при сохранении координат левой нижней вершины;
    public void decreaseRectangle(int nX, int nY) {
        x2 /= nX;
        y2 /= nY;
    }

    // метод, вычисляющий площадь Rectangle;
    @Override
    public double square() {
        return Math.abs(getX1()-x2) * Math.abs(getY1()-y2);
    }

    // метод, определяющий, лежит ли точка (x,y) внутри Rectangle;
    public boolean isPointInside(int pX, int pY) {
        return pX > getX1() &&
                pX < x2 &&
                pY > getY1() &&
                pY < y2;
    }

    // метод, определяющий, лежит ли точка Point2D(x,y) внутри Rectangle
    // (класс Point2D был рассмотрен на лекции);
    public boolean isPointInside(Point2D point) {
        return isPointInside(point.getX(), point.getY());
    }

    // метод, определяющий, пересекается ли Rectangle с другим Rectangle;
    public boolean isCrossRectangles(Rectangle rect) {
        return rect.getX1() < x2 &&
                rect.getX2() > getX1() &&
                rect.getY2() > getY1() &&
                rect.getY1() < y2;
    }

    // метод, определяющий, вложен ли данный Rectangle в другой Rectangle
    public boolean isRectangleInside(Rectangle rect) {
        return rect.getX1() < getX1() &&
                rect.getX2() > x2 &&
                rect.getY2() > y2 &&
                rect.getY1() < getY1();
    }

    // метод large, возвращающий прямоугольник с размерами сторон, увеличенными в n раз
    public Rectangle large(int xN, int yN){
        x2*=xN;
        y2*=yN;
        return this;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x1=" + getX1() +
                ", y1=" + getY1() +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", color=" + getColor() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (getX1() != rectangle.getX1()) return false;
        if (getY1() != rectangle.getY1()) return false;
        if (getX2() != rectangle.getX2()) return false;
        return getY2() == rectangle.getY2();

    }

    @Override
    public int hashCode() {
        int result = getX1();
        result = 31 * result + getY1();
        result = 31 * result + getX2();
        result = 31 * result + getY2();
        return result;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

}
