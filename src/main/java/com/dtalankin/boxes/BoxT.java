package com.dtalankin.boxes;

/**
 *     30.10.2015
 *     Dmitry Talankin
 *     Lessons #4 Task #41
 */

public class BoxT<T> {
    private T obj;

    public BoxT(T obj) {
        super();
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
