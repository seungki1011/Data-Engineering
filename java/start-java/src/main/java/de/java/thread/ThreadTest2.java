package de.java.thread;

public class ThreadTest2 {

    static long startTime = 0;

    public static void main(String[] args) {

//        Runnable r1 = new MyThread1();
//        Thread t1 = new Thread(r1);
        Thread t1 = new Thread(new MyThread1());
        Thread t2 = new Thread(new MyThread2());

        t1.start();
        t2.start();
        startTime = System.currentTimeMillis();

        try {
            t1.join(); // main 스레드가 t1의 작업이 끝날 때까지 기다린다
            t2.join(); // main 스레드가 t2의 작업이 끝날 때까지 기다린다
        } catch (InterruptedException e) {}

        System.out.println();
        System.out.println("Total task time : "+ (System.currentTimeMillis()-startTime));
    } // main 스레드
}
