/**
 *  05.12.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.Queue;

import com.dtalankin.exceptions.TraineeException;
import com.dtalankin.trainees.Trainee;

public class QueueWrapperTask89_712 {
    private Queue<Trainee> queue;

    public QueueWrapperTask89_712(Queue<Trainee> queue) {
        this.queue = queue;
        fillQueue();
    }

    public synchronized void getItem() {
        if (!queue.isEmpty()) {
            System.out.println(queue.poll());
        } else {
            System.out.println("Queue is empty : " + queue.isEmpty());
        }
    }

    private void fillQueue() {
        try {
            for (int i = 0; i < 10000; i++) {
                queue.add(new Trainee((new Integer(i)).toString(),(new Integer(i)).toString(), 4));
            }
        } catch (TraineeException e) {
            e.printStackTrace();
        }

    }
}

