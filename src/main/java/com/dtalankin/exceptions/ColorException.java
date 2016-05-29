/**
 *     04.11.2015
 *     Dmitry Talankin
 *     Lessons #5 Task #501
 */
package com.dtalankin.exceptions;


public class ColorException extends Exception{

    public ColorException() {
    }

    public ColorException(String message) {
        super(message);
    }

    public ColorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColorException(Throwable cause) {
        super(cause);
    }

    public ColorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
