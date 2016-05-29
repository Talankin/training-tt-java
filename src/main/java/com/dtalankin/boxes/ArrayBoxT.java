package com.dtalankin.boxes;

import com.dtalankin.figures.Figure;
import com.dtalankin.figures.Rectangle;

/**
 *     30.10.2015
 *     Dmitry Talankin
 *     Lessons #4 Task #412
 */

public class ArrayBoxT<T> {
    private T[] arrObj;

    public ArrayBoxT(T[] arrObj) {
        super();
        this.arrObj = arrObj;
    }

    public T[] getArrObj() {
        return arrObj;
    }

    public void setArrObj(T[] arrObj) {
        this.arrObj = arrObj;
    }
}
