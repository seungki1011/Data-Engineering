package wrapper;

public class WrapperTest3 {
    public static void main(String[] args) {

        Integer int1 = Integer.valueOf(10);
        Integer int2 = Integer.valueOf("20"); // 문자열 -> 래퍼 객체

        int intValue = Integer.parseInt("30");

        // 비교 연산
        int compareResult = int1.compareTo(int2); // int1 = 10, int2 = 20
        System.out.println("compareResult = " + compareResult);

        // 산술 연산
        System.out.println("Integer.sum(10,20) = " + Integer.sum(10,20));
        System.out.println("Integer.max(10,20) = " + Integer.max(10,20));
        System.out.println("Integer.min(10,20) = " + Integer.min(10,20));
    }
}
