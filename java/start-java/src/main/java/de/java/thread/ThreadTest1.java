package de.java.thread;

public class ThreadTest1 {
    public static void main(String[] args) {
        Runnable r1 = new MyThread1();
        Thread t1 = new Thread(r1);

        Runnable r2 = new MyThread2();
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }
}

