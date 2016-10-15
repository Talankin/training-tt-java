/**
 *  20.03.2016
 *  Dmitry Talankin
 */

package com.dtalankin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

import com.dtalankin.threads.Caller;
import com.dtalankin.threads.Callme;
import com.dtalankin.threads.MessageForSemaphore;
import com.dtalankin.threads.Thread102;
import com.dtalankin.threads.Thread104;
import com.dtalankin.threads.Thread106;
import com.dtalankin.threads.ThreadForSyncList;
import com.dtalankin.threads.ThreadWithSemaphore;
import com.dtalankin.threads.ThreadWithSyncMethods;
import com.dtalankin.threads.ThreadOne;
import com.dtalankin.threads.ThreadOneForSynch;
import com.dtalankin.threads.ThreadThree;
import com.dtalankin.threads.ThreadTwo;
import com.dtalankin.threads.ThreadTwoForSynch;
import static com.dtalankin.Print.*;
import org.junit.Test;

public class Lesson8 {

    @Test
    public void example106() {
        Thread106 t1 = new Thread106("Thread 1");
        Thread106 t2 = new Thread106("Thread 2");
        Thread106 t3 = new Thread106("Thread 3");

        print("Thread 1 is alive " + t1.getT().isAlive());
        print("Thread 2 is alive " + t2.getT().isAlive());
        print("Thread 3 is alive " + t3.getT().isAlive());
        try {
            t1.getT().join();
            t2.getT().join();
            t3.getT().join();
        } catch (InterruptedException e) {
            print("Main thread has interrupted");
        }
        print("Thread 1 is alive " + t1.getT().isAlive());
        print("Thread 2 is alive " + t2.getT().isAlive());
        print("Thread 3 is alive " + t3.getT().isAlive());

        print("Exiting main thread");
    }


    @Test
    public void example104() {
        new Thread104(6);

        try {
            for(int i=1; i<6; i++) {
                print("Main thread is working " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            print("Main thread has interrupted");
        }
        print("Exiting main thread");
    }


    @Test
    public void example103() {
        Runnable runnable = ()-> {
            try {
                for(int i=1; i<6; i++) {
                    print("Child thread is working " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                print("Child thread has interrupted");
            }
            print("Exiting child thread");
        };

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    for(int i=1; i<6; i++) {
//                        print("Child thread is working " + i);
//                        Thread.sleep(500);
//                    }
//                } catch (InterruptedException e) {
//                    print("Child thread has interrupted");
//                }
//                print("Exiting child thread");
//            }
//        };

        new Thread(runnable, "Child thread").start();

        try {
            for(int i=1; i<6; i++) {
                print("Main thread is working " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            print("Main thread has interrupted");
        }
        print("Exiting main thread");
    }

    @Test
    public void example102() {
        new Thread102();

        try {
            for(int i=1; i < 6; i++) {
                print("Main thread " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            print("Main thread interrupted");
        }
        print("Exiting main thread");
    }


/**
    ***********************************************
    I start lessons 8-10 again. These will be above.
    15.10.2016
    ***********************************************
*/


    @Test
    public void task87() {
        System.out.println("\n================================ Task #8.7");
        Semaphore semaphore = new Semaphore(1);
        MessageForSemaphore messageObject = new MessageForSemaphore();
        ThreadWithSemaphore threadPing = new ThreadWithSemaphore(semaphore, messageObject, "Ping");
        ThreadWithSemaphore threadPong = new ThreadWithSemaphore(semaphore, messageObject, "Pong");

        try {
            threadPing.thread.join();
            threadPong.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Exiting thread Main");
    }

    @Test
    public void task86() {
        System.out.println("\n================================ Task #8.6");
        List<Integer> list = new ArrayList<>();
        List<Integer> syncList = Collections.synchronizedList(list);
        ThreadForSyncList threadForSyncListsAdd = new ThreadForSyncList(syncList, 1, "adding");
        ThreadForSyncList threadForSyncListsDel = new ThreadForSyncList(syncList, 2, "deleting");

        try {
            threadForSyncListsAdd.thread.join();
            threadForSyncListsDel.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Exiting thread Main");

    }

    @Test
    public void task85() {
        System.out.println("\n================================ Task #8.5");
        List<Integer> array = new ArrayList<>();
        ThreadWithSyncMethods threadWithSyncMethodsAdd = new ThreadWithSyncMethods(array, 1, "adding");
        ThreadWithSyncMethods threadWithSyncMethodsDel = new ThreadWithSyncMethods(array, 2, "deleting");

        try {
            threadWithSyncMethodsAdd.thread.join();
            threadWithSyncMethodsDel.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Exiting thread Main");

    }

    @Test
    public void task84() {
        System.out.println("\n================================ Task #8.4");
        List<Integer> array = new ArrayList<>();

        ThreadOneForSynch threadOneForSynch = new ThreadOneForSynch(array);
        ThreadTwoForSynch threadTwoForSynch = new ThreadTwoForSynch(array);

        try {
            threadOneForSynch.thread.join();
            threadTwoForSynch.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Exiting thread Main");

    }

    @Test
    public void example107() {
        System.out.println("\n================================ Example #107");
        Callme callme = new Callme();
        Caller callerOne = new Caller(callme, "Message One");
        Caller callerTwo = new Caller(callme, "Message Two");
        Caller callerThree = new Caller(callme, "Message Three");

        try {
            callerOne.thread.join();
            callerTwo.thread.join();
            callerThree.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task83() {
        System.out.println("\n================================ Task #8.3");
        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();
        ThreadThree threadThree = new ThreadThree();
        print("Thread One lives : " + threadOne.thread.isAlive());
        print("Thread Two lives : " + threadTwo.thread.isAlive());
        print("Thread Three lives : " + threadThree.thread.isAlive());

        // waiting for threads to finish
        try {
            threadOne.thread.join();
            threadTwo.thread.join();
            threadThree.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        print("Thread One lives : " + threadOne.thread.isAlive());
        print("Thread Two lives : " + threadTwo.thread.isAlive());
        print("Thread Three lives : " + threadThree.thread.isAlive());
        print("Exiting thread Main");
    }

        @Test
    public void task82() {
        System.out.println("\n================================ Task #8.2");
        // create a new thread
        ThreadForMultithread threadFirst = new ThreadForMultithread("First");
        ThreadForMultithread threadSecond = new ThreadForMultithread("Second");
        print("First Thread lives : " + threadFirst.thread.isAlive());
        print("Second Thread lives : " + threadSecond.thread.isAlive());

        // wait for threads to finish
        try {
            threadFirst.thread.join();
        } catch (InterruptedException e) {
            print("main Thread interrupted");
        }
        print("First Thread lives : " + threadFirst.thread.isAlive());
        print("Second Thread lives : " + threadSecond.thread.isAlive());
        print("Exiting thread Main");
    }

    @Test
    public void task81() {
        System.out.println("\n================================ Task #8.1");
        new ExtThread(); // create a new thread
    }

    @Test
    public void multiThread() {
        // Если в первичном потоке выставить малое время сна
        // то первычный поток закончит работу, не дожидаясь завершения
        // дочерних потоков
        new ThreadForMultithread("One"); // create a new thread
        new ThreadForMultithread("Two"); // create a new thread
        new ThreadForMultithread("Three"); // create a new thread

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }

    @Test
    public void runThread1() {
        new MyThread(); // create a new thread

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }

    @Test
    public void runThread2() {
        new ExtThread(); // create a new thread

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}

class ExtThread extends Thread {
    public ExtThread() {
        // Create a new, second thread
        super("Demo Thread");
        System.out.println("Child thread start ... " + this);
        start(); // Start the thread
    }

    // This is the entry point for the second thread
    @Override
    public void run() {
        try {
            System.out.println("Child thread properties getId: " + this.getId());
            System.out.println("getName: " + this.getName());
            System.out.println("getContextClassLoader: " + this.getContextClassLoader());
            System.out.println("getPriority: " + this.getPriority());
            System.out.println("getState: " + this.getState());
            System.out.println("getThreadGroup: " + this.getThreadGroup());
            System.out.println("isInterrupted: " + this.isInterrupted());
            System.out.println("isAlive: " + this.isAlive());
            for (int i=5; i>0; i--) {
                System.out.println(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

class MyThread implements Runnable {
    Thread thread;

    MyThread() {
        thread = new Thread(this, "Lesson 8 thread");
        System.out.println("Child thread: " + thread);
        thread.start(); //start the thread
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

class ThreadForMultithread implements Runnable {
    private String threadName;
    Thread thread;

    ThreadForMultithread(String threadName) {
        this.threadName = threadName;
        thread = new Thread(this, this.threadName);
        System.out.println("Child thread: " + thread);
        thread.start(); //start the thread
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Thread " + threadName + " : " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted " + threadName);
        }
        System.out.println("Exiting thread " + threadName);
    }
}
