/**
 *  09.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.List;

import static com.dtalankin.Print.print;

public class ProductTask86 {
    private List<Integer> array;

    public ProductTask86(List<Integer> array) {
        this.array = array;
    }

    public void remove() {
        int index = (int) (Math.random() * array.size());
        if (array.size()>0) {
            array.remove(index);
            print("Removed index = " + index + "; size = " + array.size());
        }
    }

    public void add() {
        array.add((int) (Math.random() * 10000));
        print("Added number; size = " + array.size());
    }

}
