/**
 *  19.11.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.Collections;
import java.util.List;

import com.dtalankin.trainees.Trainee;

public class ListShifterTask89 implements Runnable {
    private List<Trainee> trainees;
    public Thread t;

    public ListShifterTask89(List<Trainee> trainees) {
        this.trainees = trainees;
        t = new Thread(this, "ListShifter Thread");
        t.start();
    }

    @Override
    public void run() {
        //2
        trainees.add(null);
        trainees.add(null);
        int size = trainees.size();
        int shift=2;
        for(int i=size-1; i>=0; i--) {
            if(i<shift) {
                trainees.set(i, null);
            } else {
                trainees.set(i, trainees.get(i - shift));
            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("2 ***** after shifting in 2 positions to right *****");
        for(Trainee trainee : trainees) {
            System.out.println(trainee);
        }
        System.out.println("2 ***** exit *****");
    }
}
