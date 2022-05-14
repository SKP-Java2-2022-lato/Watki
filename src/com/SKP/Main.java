package com.SKP;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	   // simpleThread();
       /// classRun();
        //race();
        //NaiveConsumerProducer.run();
        //ConsumerProducer.run();
       // Volatile.run();
        new NestedThread(3).run();


    }

    private static void classRun() {
        MyThread myThread = new MyThread();
        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();
    }


    private static void simpleThread(){
        Thread thread = new Thread(() ->{
            System.out.println("T0 start");
            for(int i=0; i<5; i++)
                System.out.println("T0 "+ i);
            System.out.println("T0 stop");
        });

        thread.start();

        for(int i=0; i<5; i++)
            System.out.println("MT "+ i);
        System.out.println("MT stop");


    }

    private static void race() throws InterruptedException {
        Counter c = new Counter();

        Runnable r = () ->{
            for(int i=0; i <100_000; i++){
                c.increment();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(c.getValue());

    }
}
