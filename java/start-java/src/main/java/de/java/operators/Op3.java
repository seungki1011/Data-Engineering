package de.java.operators;

public class Op3 {
    public static void main(String[] args) {

        String str1 = "Hello World";
        String str2 = "Hello World";
        String str3 = "Bye Bye World";

        // 문자열의 비교
        // .equals() 사용

        System.out.println("str1 : Hello World, str2 : Hello World, str3 : Bye Bye World");
        System.out.println("compare hello world with hello world : " + "hello world".equals("hello world"));
        System.out.println("compare str1 with Hello World : " + str1.equals("Hello World"));
        System.out.println("compare str1 with str2 : " + str1.equals(str2));
        System.out.println("compare str1 with str3 : " + str1.equals(str3));

    }
}
