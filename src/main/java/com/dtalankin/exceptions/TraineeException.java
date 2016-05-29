/**
 *     06.11.2015
 *     Dmitry Talankin
 *     Lessons #5 Task #4
 */

package com.dtalankin.exceptions;


public class TraineeException extends Exception{
    public TraineeException() {
    }

    public TraineeException(String message) {
        super(message);
    }

    public TraineeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TraineeException(Throwable cause) {
        super(cause);
    }

    public TraineeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
