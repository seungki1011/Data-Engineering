package objectpractice;

public class EqualsTest {
    public static void main(String[] args) {
        String s1 = new String("Hello world!");
        String s2 = new String("Hello world!");

        // 1. s1과 s2는 똑같이 "Hello world!"로 값이 똑같다
        boolean isEqual = s1.equals(s2);
        System.out.println("s1과 s2는 동등한가? : " + isEqual);

        // 2. s1과 s2는 new String()으로 생성이 되었기 때문에 heap 메모리에 서로 다른 객체가 생성된다
        // s1과 s2는 동일하지 않다
        boolean isSameObject = (s1 == s2);
        System.out.println("s1과 s2는 동일한가? : " + isSameObject);

        // 3. literal로 String을 생성하면 string pool에 있는 같은 메모리를 참조한다
        String s3 = "Hello world!";
        String s4 = "Hello world!";

        // s3와 s4는 "Hello world!"로 값이 같다
        boolean isEqual2 = s3.equals(s4);
        System.out.println("s3와 s4는 동등한가? : " + isEqual2);

        // s3와 s4는 literal로 String을 생성했기 때문에 string pool의 같은 메모리 참조
        // s3와 s4는 동일하다
        boolean isSameObject2 = (s3 == s4);
        System.out.println("s3과 s4는 동일한가? : " + isSameObject2);

    }
}
