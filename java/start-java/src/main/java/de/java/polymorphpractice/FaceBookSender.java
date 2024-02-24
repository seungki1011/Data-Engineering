package de.java.polymorphpractice;

public class FaceBookSender implements Sender{
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending FaceBook Message: "+message);
    }
}
