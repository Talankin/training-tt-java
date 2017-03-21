/**
 *  24.02.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatterTask813 {
    private SimpleDateFormat sdFormat;

    public FormatterTask813(String format) {
        sdFormat = new SimpleDateFormat(format);
    }

    public void format(Date date, String name, String format) throws ParseException {
        sdFormat.applyPattern(format);
        System.out.println(name + "=" + sdFormat.format(date) + "=");

    }
}
