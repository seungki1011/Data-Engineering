package de.java.staticmethod;

public class StaticMethodMain {
    public static void main(String[] args) {
        String s = "This is the string value";
        // 클래스명.메서드명 으로 접근
        String result = StaticMethod1.addDecoration(s);

        System.out.println(s);
        System.out.println(result);
    }
}
