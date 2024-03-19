package de.java.thread;

import javax.swing.*;

public class IoBlockTest {
    public static void main(String[] args) {
        // Single Thread
        String input = JOptionPane.showInputDialog("Enter Value : ");
        System.out.println("Entered Value = " + input);

        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
