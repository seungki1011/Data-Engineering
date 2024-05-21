package de.generic.genericmethod;

public class GenericMethod {

    public static Object objMethod(Object obj) {
        System.out.println("object print: " + obj);
        return obj;
    }

    // 타입 인자를 전달 받는 시점은 메서드를 호출할 때
    public static <T> T genericMethod(T t) {
        System.out.println("generic print: " + t);
        return t;
    }

    // extends를 통한 타입 매개변수 제한도 가능
    public static <T extends Number> T numberMethod(T t) {
        System.out.println("number print: " + t);
        return t;
    }
}
