package de.java.thread;

public class MyThread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
