package com.dtalankin;

/**
 * Created by root on 10/27/15.
 */
public class Gen<T> {
    private T obj;

    public Gen(T obj) {
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
