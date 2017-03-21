/**
 *  27.02.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

public class ThreadTask813 extends Thread{
    private FormatterTask813 formatter;
    private String name, format;
    public Thread t;


    public ThreadTask813(FormatterTask813 formatter, String name, String format) {
        this.formatter = formatter;
        this.name = name;
        this.format = format;
        this.start();
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            try {
                formatter.format(Date.from(Instant.now()), name, format);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
