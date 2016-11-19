/**
 *  19.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.concurrent.Exchanger;
import static com.dtalankin.Print.*;

public class SpySetter115 extends Thread {
    private Exchanger<String> exchanger;
    private String suitcase = "";

    public SpySetter115(Exchanger<String> exchanger) {
        super("SpySetter Thread");
        this.exchanger = exchanger;
        this.start();
    }

    @Override
    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                suitcase += ch++;
            }
            try {
                suitcase = exchanger.exchange(suitcase);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
