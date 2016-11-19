/**
 *  19.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Exchanger;
import static com.dtalankin.Print.*;

public class SpyGetter115 extends Thread {
    private Exchanger<String> exchanger;
    private String suitcase;

    public SpyGetter115(Exchanger<String> exchanger) {
        super("SpyGetter Thread");
        this.exchanger = exchanger;
        this.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                suitcase = exchanger.exchange(new String());
                print(this.getName() + " got cypher : " + suitcase);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
