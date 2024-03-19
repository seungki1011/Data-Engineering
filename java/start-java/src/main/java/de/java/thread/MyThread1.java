package de.java.thread;

class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("[" + Thread.currentThread().getName() + "]");
        }
    }
}
