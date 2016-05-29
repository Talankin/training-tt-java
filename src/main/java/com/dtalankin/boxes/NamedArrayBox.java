/**
 *     01.11.2015
 *     Dmitry Talankin
 *     Lessons #4 Task #418
 */

package com.dtalankin.boxes;

import com.dtalankin.figures.Rectangle;

public class NamedArrayBox<T> extends ArrayBox {
    private String name;

    public NamedArrayBox(Rectangle[] arrObj, String name) {
        super(arrObj);
        this.name = name;
    }
}
