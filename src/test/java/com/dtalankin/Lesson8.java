/**
 *  20.03.2016
 *  Dmitry Talankin
 */

package com.dtalankin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.dtalankin.threads.*;

import static com.dtalankin.Print.*;

import com.dtalankin.trainees.Trainee;
import org.junit.Test;

public class Lesson8 {
    /**
     * Send messages to real smtp server
     */
    @Test
    public void task814_2() {
        List<String> addresses = new ArrayList<>();
        List<Future<?>> futures = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(2);
        TransportTask814 transport = new TransportTask814();

        try(BufferedReader br = new BufferedReader(new FileReader("src/test/resources/com/dtalankin/Lesson8/addresses.txt"))) {
            String address;
            while ((address = br.readLine()) != null) {
                addresses.add(address);
            }
            Collections.shuffle(addresses);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        for (String address : addresses) {
            MessageTask814 message = new MessageTask814(address, "from dimir", "eat more french cookies", "this is a body. this is a big body");
            Future<?> future = es.submit(new ThreadTask814(transport, message));
            futures.add(future);
        }

        try {
            for (Future<?> f : futures) {
                f.get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        es.shutdown();
        System.out.println("Done");
    }


    /**
     * Send messages to file
     */
    @Test
    public void task814_1() {
        List<String> addresses = new ArrayList<>();
        List<Future<?>> futures = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(2);
        TransportTask814 transport = new TransportTask814();

        try(BufferedReader br = new BufferedReader(new FileReader("src/test/resources/com/dtalankin/Lesson8/addresses.txt"))) {
            String address;
            while ((address = br.readLine()) != null) {
                addresses.add(address);
            }
            Collections.shuffle(addresses);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        for (String address : addresses) {
            MessageTask814 message = new MessageTask814(address, "from dimir", "eat more french cookies", "this is a body. this is a big body");
            Future<?> future = es.submit(new ThreadTask814(transport, message));
            futures.add(future);
        }

        try {
            for (Future<?> f : futures) {
                f.get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        es.shutdown();
        System.out.println("Done");
    }


    @Test
    public void lesson120() {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> f1;
        Future<Double> f2;
        Future<Integer> f3;

        System.out.println("go go go... ");

        f1 = es.submit(new Factorial120(9));
        f2 = es.submit(new Hypot120(4,5));
        f3 = es.submit(new Sum120(8));

        try {
            System.out.println(f1.get());
            System.out.println("f1 is stoped ");
            System.out.println(f2.get());
            System.out.println("f2 is stoped ");
            System.out.println(f3.get());
            System.out.println("f3 is stoped ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        es.shutdown();
    }


    @Test
    public void task813() {
        FormatterTask813 formatter = new FormatterTask813("yyyy.MM.dd");
        ThreadTask813 t1 = new ThreadTask813(formatter, "A", "h:mm a");
        ThreadTask813 t2 = new ThreadTask813(formatter, "B", "K:mm a, z");
        ThreadTask813 t3 = new ThreadTask813(formatter, "C", "EEE, d MMM yyyy HH:mm:ss Z");
        ThreadTask813 t4 = new ThreadTask813(formatter, "D", "yyMMddHHmmssZ");
        ThreadTask813 t5 = new ThreadTask813(formatter, "E", "yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void task812() {
        ConcurrentHashMapTask812 map = new ConcurrentHashMapTask812();
        ProducerTask812 prod = new ProducerTask812(map, "A");
        ConsumerTask812 cons = new ConsumerTask812(map, "B");
        ProducerTask812 prod1 = new ProducerTask812(map, "C");
        ConsumerTask812 cons1 = new ConsumerTask812(map, "D");
        ProducerTask812 prod2 = new ProducerTask812(map, "E");
        ConsumerTask812 cons2 = new ConsumerTask812(map, "F");

        try {
            prod.t.join();
            cons.t.join();
            prod1.t.join();
            cons1.t.join();
            prod2.t.join();
            cons2.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task811() {
        PingPongBufferTask811 buffer = new PingPongBufferTask811();
        PingThreadTask811 ping = new PingThreadTask811(buffer);
        PongThreadTask811 pong = new PongThreadTask811(buffer);

        try {
            ping.t.join();
            pong.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void task810() {
        Lock lock = new ReentrantLock();
        List<Integer> array = new ArrayList<>();

        ProducerTask810 producer = new ProducerTask810(lock, array, "A");
        RemoverTask810 consumer = new RemoverTask810(lock, array, "B");

        try {
            producer.t.join();
            consumer.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void task89From712() {
        Queue<Trainee> queue = new PriorityQueue<>((t1, t2) -> t1.getRating().compareTo(t2.getRating()));
        QueueWrapperTask89_712 queueWrapper = new QueueWrapperTask89_712(queue);

        FacultyDirectorTask89_712 facultyDirector = new FacultyDirectorTask89_712(queueWrapper, "Thread 1");
        FacultyDirectorTask89_712 facultyDirector1 = new FacultyDirectorTask89_712(queueWrapper, "Thread 2");
        FacultyDirectorTask89_712 facultyDirector2 = new FacultyDirectorTask89_712(queueWrapper, "Thread 3");
        FacultyDirectorTask89_712 facultyDirector3 = new FacultyDirectorTask89_712(queueWrapper, "Thread 4");

        try {
            facultyDirector.t.join();
            facultyDirector1.t.join();
            facultyDirector2.t.join();
            facultyDirector3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void task89From711() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        BlackFridayGoodsTask89_711 stock = new BlackFridayGoodsTask89_711(arrayList);
        BuyerTask89_711 buyer = new BuyerTask89_711(stock, "Stock with ArrayList 1");
        BuyerTask89_711 buyer1 = new BuyerTask89_711(stock, "Stock with ArrayList 2");
        BuyerTask89_711 buyer2 = new BuyerTask89_711(stock, "Stock with ArrayList 3");

        BlackFridayGoodsTask89_711 stock1 = new BlackFridayGoodsTask89_711(linkedList);
        BuyerTask89_711 buyer3 = new BuyerTask89_711(stock1, "Stock with LinkedList 1");
        BuyerTask89_711 buyer4 = new BuyerTask89_711(stock1, "Stock with LinkedList 2");
        BuyerTask89_711 buyer5 = new BuyerTask89_711(stock1, "Stock with LinkedList 3");

        try {
            buyer.t.join();
            buyer1.t.join();
            buyer2.t.join();
            buyer3.t.join();
            buyer4.t.join();
            buyer5.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lesson118() {
        Buffer118 buffer = new Buffer118();
        Producer118 producer = new Producer118(buffer);
        Consumer118 consumer = new Consumer118(buffer);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void lesson117() {
        //for normally  working this lesson : copy+past block to Main.main() and run it.
        ReadWriteLock lock = new ReentrantReadWriteLock();
        for (int i = 0; i < 3; i++) {
            new WriterLockThread117(lock);
            new ReaderLockThread117(lock);
            new WriterLockThread117(lock);
            new ReaderLockThread117(lock);
            new WriterLockThread117(lock);
            new ReaderLockThread117(lock);
        }
    }


    @Test
    public void lesson116() {
        Lock lock = new ReentrantLock();
        LockThread116 lockThreadA = new LockThread116("A", lock);
        LockThreadB116 lockThreadB = new LockThreadB116("B", lock);

        try {
            lockThreadA.t.join();
            lockThreadB.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void lesson115() {
        Exchanger<String> exchanger = new Exchanger<>();
        SpyGetter115 spyGetter = new SpyGetter115(exchanger);
        SpySetter115 spySetter = new SpySetter115(exchanger);

        try {
            spySetter.join();
            spyGetter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void lesson114() {
        CyclicBarrier barrier = new CyclicBarrier(3, new ThreadBarAction114());
        Thread114 thread1 = new Thread114(barrier, "A", 5000);
        Thread114 thread2 = new Thread114(barrier, "B", 10000);
        Thread114 thread3 = new Thread114(barrier, "C", 8000);

        try {
            thread1.t.join();
            thread2.t.join();
            thread3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lesson113() {
        CountDownLatch latch = new CountDownLatch(20);
        print("CountDown starting...");
        ThreadOne113 thread1 = new ThreadOne113(latch);
        ThreadTwo113 thread2 = new ThreadTwo113(latch);

        try {
            thread1.join();
            print("Thread 1 has been done");
            thread2.join();
            print("Thread 2 has been done");
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Main thread has been done");
    }

    @Test
    public void taskOne88() {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        BookOne88 book = new BookOne88();

        ReaderOne88 reader = new ReaderOne88(book, lock);
        WriterOne88 writer = new WriterOne88(book, lock);

        try {
            reader.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task88() {
        Book88 book = new Book88();
        Reader88 reader = new Reader88(book);
        Writer88 writer = new Writer88(book);

        try {
            reader.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void newTask87() {
        PingPong87 pingPong = new PingPong87();
        PingThread87 ping = new PingThread87(pingPong);
        PongThread87 pong = new PongThread87(pingPong);

        try {
            ping.t.join();
            pong.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void newTask86() {
        /**
         * we have to sinchronize a list and sinchronize the methods too,
         * otherwise the result can has non-deterministic behavior.
         * But P.L.Dvorkin said we are not waiting deterministic behaviour.
         * The main idea - difference working with list.
         */
        List<Integer> array = new ArrayList<>();
        List<Integer> syncArray = Collections.synchronizedList(array);

        ProductTask86 prod = new ProductTask86(syncArray);

        ProducerTask86 producer = new ProducerTask86(prod);
        ConsumerTask86 consumer = new ConsumerTask86(prod);

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void newTask85() {
        // we need cover the array by class with synchronized methods
        ArrayList<Integer> array = new ArrayList<>();
        ProductTask85 prod = new ProductTask85(array);

        ProducerTask85 producer = new ProducerTask85(prod);
        ConsumerTask85 consumer = new ConsumerTask85(prod);

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void newTask84() {
        ArrayList<Integer> array = new ArrayList<>();
        ProducerTask84 prod = new ProducerTask84(array);
        ConsumerTask84 cons = new ConsumerTask84(array);

        try {
            prod.t.join();
            cons.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void exampleExtandsThreadSemaphor() {
        ProductExtThread product = new ProductExtThread();
        ProducerExtThread producer = new ProducerExtThread(product);
        ConsumerExtThread consumer = new ConsumerExtThread(product);

        try {
            consumer.join();
            producer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void exampleLambdaSemaphore() {
        ProductSemLamb product = new ProductSemLamb();
        ProducerSemLamb producer = new ProducerSemLamb(product);
        ConsumerSemLamb consumer = new ConsumerSemLamb(product);

        try {
            consumer.t.join();
            producer.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void example112() {
        Product112 product = new Product112();
        Producer112 producer = new Producer112(product);
        Consumer112 consumer = new Consumer112(product);
    }

        @Test
    public void example111() {
        Semaphore semaphore = new Semaphore(1);
        IncreaseThread111 incThread = new IncreaseThread111(semaphore, "A (inc)");
        DecreaseThread111 decThread = new DecreaseThread111(semaphore, "B (dec)");
    }

    @Test
    public void example110() {
        // Inner synchronized section in Product110
        Product110 product = new Product110();
        Producer110 producer = new Producer110(product);
        Consumer110 consumer = new Consumer110(product);
    }

    @Test
    public void example109() {
        // Inner synchronized section in Product109
        Product109 product = new Product109();
        Producer109 producer = new Producer109(product);
        Consumer109 consumer109 = new Consumer109(product);

        print("Type Ctrl+C to stop programm");
    }


        @Test
    public void example108() {
        // Outer synchronized section in Caller108
        Callme107 callme = new Callme107();
        Caller108 caller1 = new Caller108(callme, "Hello", "Thread 1");
        Caller108 caller2 = new Caller108(callme, "Synchronized", "Thread 2");
        Caller108 caller3 = new Caller108(callme, "World", "Thread 3");

        try {
            caller1.join();
            caller2.join();
            caller3.join();
        } catch (InterruptedException e) {
            print("Interrupted");
        }
    }


    @Test
    public void newExample107() {
        Callme107 callme = new Callme107();
        Caller107 caller1 = new Caller107(callme, "Hello", "Thread 1");
        Caller107 caller2 = new Caller107(callme, "Synchronized", "Thread 2");
        Caller107 caller3 = new Caller107(callme, "World", "Thread 3");

        try {
            caller1.join();
            caller2.join();
            caller3.join();
        } catch (InterruptedException e) {
            print("Interrupted");
        }
    }


    @Test
    public void newTask83() {
        ThreadOneForTask83 t1 = new ThreadOneForTask83();
        ThreadTwoForTask83 t2 = new ThreadTwoForTask83();
        ThreadThreeForTask83 t3 = new ThreadThreeForTask83();

        try {
            for (int i = 1; i < 6; i++) {
                print("Main Thread " + " n = " + i);
                Thread.sleep(500);
            }
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            print("Main Thread interrupted");
        }
        print("Exiting main thread");
    }


    @Test
    public void newTask82() {
        Thread106 t1 = new Thread106("Thread 1");

        try {
            t1.getT().join();
        } catch (InterruptedException e) {
            print("Main thread has interrupted");
        }

        print("Exiting main thread");
    }

    @Test
    public void newTask81(){
        Thread106 t1 = new Thread106("Thread 1");
        print("Thread 1 is alive " + t1.getT().isAlive());
        print("Thread 1 isInterrupted " + t1.getT().isInterrupted());
        print("Thread 1 getState " + t1.getT().getState());
        print("Thread 1 getName " + t1.getT().getName());
        print("Thread 1 getId " + t1.getT().getId());
        print("Thread 1 getPriority " + t1.getT().getPriority());
        print("Thread 1 getStackTrace().length " + t1.getT().getStackTrace().length);
        print("Thread 1 isDaemon " + t1.getT().isDaemon());
        print("Thread 1 is alive " + t1.getT().isAlive());

        print("Exiting main thread");

    }

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
        Thread104 t1 = new Thread104(6);
        print(t1);
        print("Name is " + t1.getName());

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
