package stringpractice;

public class StringTest2 {
    public static void main(String[] args) {
        String str = "광물 기타 중요한 지하자원·수산자원·수력과 경제상 이용할 수 있는 " +
                "자연력은 법률이 정하는 바에 의하여 일정한 기간 그 채취·개발 또는 이용을 특허할 수 있다.";

        System.out.println("문자열 길이 = " + str.length());
        System.out.println("문자열 비어 있나요? = " + str.isEmpty());
        System.out.println("믄자열 비어 있거나 공백이 있나요? = " + str.isBlank()); // Java 11 부터
        System.out.println("4번 인덱스의 문자 = " + str.charAt(4));

    }
}
