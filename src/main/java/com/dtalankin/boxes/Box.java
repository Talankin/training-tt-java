/**
 *     30.10.2015
 *     Dmitry Talankin
 *     Lessons #4 Task #45
 */

package com.dtalankin.boxes;

import com.dtalankin.figures.Figure;
import com.dtalankin.figures.Rectangle;
import com.dtalankin.figures.Square;

public class Box<T extends Figure> implements Square {
    private T obj;
    private final static double EPS = 0.01;

    public Box(T obj) {
        super();
        this.obj = obj;
    }

    /* Can't instantiate T
    public T create () {
        return new T();
    }
    */

    public double square() {
        return obj.square();
    }

    public boolean isSameSquare(Box<? extends Rectangle> box) {
        return Math.abs(square() - box.square()) <= EPS;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
