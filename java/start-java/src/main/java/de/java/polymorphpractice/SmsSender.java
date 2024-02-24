package de.java.polymorphpractice;

public class SmsSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: "+message);
    }
}
