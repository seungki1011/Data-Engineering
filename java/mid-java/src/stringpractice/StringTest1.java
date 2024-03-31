package stringpractice;

public class StringTest1 {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = " world!";

        str1.concat(str2); // 그냥 메서드를 호출하는 것만으로는 아무것도 못한다

        // String은 불변이기 떼문에 값을 변경하는 메서드는 무조건 객체를 반환한다
        String str3 = str1.concat(str2);
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("str3 = " + str3);

    }
}
