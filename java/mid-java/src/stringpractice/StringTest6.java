package stringpractice;

public class StringTest6 {
    public static void main(String[] args) {
        String strWithSpace = "   Hello world!   ";

        System.out.println("소문자로 변환 = " + strWithSpace.toLowerCase());
        System.out.println("대문자로 변환 = " + strWithSpace.toUpperCase());

        System.out.println("원본 문자열 = \"" + strWithSpace + "\"");
        System.out.println("공백 제거(trim) = \"" + strWithSpace.trim() + "\"");
        System.out.println("공백 제거(strip) = \"" + strWithSpace.strip() + "\"");

        System.out.println("머리쪽 공백 제거 = \"" + strWithSpace.stripLeading() + "\"");
        System.out.println("꼬리쪽 공백 제거 = \"" + strWithSpace.stripTrailing() + "\"");
    }
}
