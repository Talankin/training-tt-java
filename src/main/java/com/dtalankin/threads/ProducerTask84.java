/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.List;
import static com.dtalankin.Print.*;

public class ProducerTask84 {
    private List<Integer> array;
    public Thread t;

    public ProducerTask84(List<Integer> array) {
        this.array = array;
        t = new Thread(runnable, "Producer Thread");
        t.start();
    }

    Runnable runnable = () -> {

        int n = 10000;
        for (int i=0; i<n; i++) {
            synchronized (array) {
                array.add((int) (Math.random() * n));
                print("Producer size = " + array.size());
            }
        }

    };
}
