/**
 *     30.10.2015
 *     Dmitry Talankin
 *     Lessons #4 Task #416
 */

package com.dtalankin.boxes;

import com.dtalankin.figures.Figure;
import com.dtalankin.figures.Rectangle;


public class ArrayBox<T extends Rectangle> {
    private T[] arrObj;

    public ArrayBox(T[] arrObj) {
        super();
        this.arrObj = arrObj;
    }

    /* Can't instantiate T
    public T[] create() {
        return new T[5];
    }*/

    public T[] getArrObj() {
        return arrObj;
    }

    public void setArrObj(T[] arrObj) {
        this.arrObj = arrObj;
    }
}
