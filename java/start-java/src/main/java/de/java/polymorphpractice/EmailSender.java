package de.java.polymorphpractice;

public class EmailSender implements Sender{

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Mail: "+message);
    }
}
