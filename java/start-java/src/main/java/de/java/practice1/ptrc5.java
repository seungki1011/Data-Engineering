package de.java.practice1;

public class ptrc5 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int temp;
        System.out.println("Before swap a = "+a+", b = "+b);
        temp = a;
        a = b;
        b = temp;
        System.out.println("After swap a = "+a+", b = "+b);

    }
}
