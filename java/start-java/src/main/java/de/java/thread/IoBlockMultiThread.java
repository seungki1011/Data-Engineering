package de.java.thread;

import javax.swing.*;

public class IoBlockMultiThread {
    public static void main(String[] args) {
        // Multi Thread
        Thread t2 = new Thread(new MyThread3());
        t2.start();

        String input = JOptionPane.showInputDialog("Enter Value : ");
        System.out.println("Entered Value = " + input);
    }
}
