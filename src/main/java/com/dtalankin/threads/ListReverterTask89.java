/**
 *  19.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.Collections;
import java.util.List;

import com.dtalankin.trainees.Trainee;

public class ListReverterTask89 implements Runnable {
    private List<Trainee> trainees;
    public Thread t;

    public ListReverterTask89(List<Trainee> trainees) {
        this.trainees = trainees;
        t = new Thread(this, "ListReverter Thread");
        t.start();
    }

    @Override
    public void run() {
        //1
        Collections.reverse(trainees);
        System.out.println("1 ***** after reverse *****");
        for (Trainee trainee : trainees) {
            System.out.println(trainee);
        }
        System.out.println("1 ***** exit *****");
    }
}
