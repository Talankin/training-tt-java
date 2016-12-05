/**
 *  05.12.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class FacultyDirectorTask89_712 {
    private QueueWrapperTask89_712 queue;
    private String name;
    public Thread t;

    public FacultyDirectorTask89_712(QueueWrapperTask89_712 queue, String name) {
        this.queue = queue;
        this.name = name;
        t = new Thread(runnable, this.name);
        t.start();
    }

    private Runnable runnable = () -> {
        for (int i = 0; i < 3000; i++) {
            queue.getItem();
        }
        System.out.println(name + " exiting ...");
    };
}