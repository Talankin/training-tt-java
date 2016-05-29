/**
 *     01.11.2015
 *     Dmitry Talankin
 *     Lessons #4 Task #423
 */

package com.dtalankin;

import com.dtalankin.exceptions.ColorException;

import java.io.Serializable;

public enum Color /*implements Serializable*/ {

    RED,
    GREEN,
    BLUE,
    YELLOW,
    WHITE,
    BLACK;

    public static Color colorStr(String color) throws ColorException {
        try {
            return Color.valueOf(color);
        } catch (IllegalArgumentException ex) {
            throw new ColorException("Отсутствует цвет : " + color, ex);
        }
    }

}
