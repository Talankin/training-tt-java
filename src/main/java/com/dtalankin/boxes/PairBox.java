/**
 *     01.11.2015
 *     Dmitry Talankin
 *     Lessons #4 Task #419
 */

package com.dtalankin.boxes;


import com.dtalankin.figures.Circle;
import com.dtalankin.figures.Figure;
import com.dtalankin.figures.Rectangle;

public class PairBox<T extends Figure, V extends Figure> {
    private T objT;
    private V objV;
    private final static double EPS = 0.01;

    public PairBox(T objT, V objV) {
        super();
        this.objT = objT;
        this.objV = objV;
    }

    public boolean isSameSquare() {
        return Math.abs(objT.square() - objV.square()) <= EPS;
    }

    public T getObjT() {
        return objT;
    }

    public void setObjT(T objT) {
        this.objT = objT;
    }

    public V getObjV() {
        return objV;
    }

    public void setObjV(V objV) {
        this.objV = objV;
    }
}
