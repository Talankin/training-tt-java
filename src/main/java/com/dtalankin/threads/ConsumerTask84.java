/**
 *  05.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.List;
import static com.dtalankin.Print.*;

public class ConsumerTask84 {
    private List<Integer> array;
    public Thread t;

    public ConsumerTask84(List<Integer> array) {
        this.array = array;
        t = new Thread(runnable, "Consumer Thread");
        t.start();
    }

    private Runnable runnable = () -> {
        int n = 10000;
        for(int i=0; i<n; i++) {
            synchronized (array) {
                print("Consumer size before removing = " + array.size());
                int index = (int) (Math.random() * array.size());
                if (array.size()>0) {
                    array.remove(index);
                }
                print("Consumer size after = " + array.size() + "; removed element index " + index);
            }
        }
        print("Exiting from consumer Thread");
    };
}
