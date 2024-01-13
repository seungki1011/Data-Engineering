package de.java.exception;

public class ExceptionMain5 {
    public static void main(String[] args) { // main에서 throws Exception 하면 JVM으로 넘김
        try {
            System.out.println("Called method1");
            method1();
        } catch (Exception e) {
            System.out.println("Handled Exception in main");
        }
    }
    static void method1() throws Exception {
        System.out.println("method1 calls method2");
        method2();
    }
    static void method2() throws Exception{
        System.out.println("Exception is made in method2");
        throw new Exception();
    }
}
