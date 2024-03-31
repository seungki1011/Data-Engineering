package stringpractice;

public class StringTest5 {
    public static void main(String[] args) {
        String str = "The verdant meadows stretched out before us.";

        System.out.println("인덱스 7부터의 부분 문자열 = " + str.substring(7));
        System.out.println("인덱스 7부터 12까지의 부분 문자열 = " + str.substring(7, 12));
        System.out.println("문자열 + '..' 결합 = " + str.concat(".."));

        System.out.println("'meadows'을 'mountain'으로 대체: " + str.replace("meadows", "mountain"));
        System.out.println("첫 번째 'The'를 'Those'로 대체: " + str.replaceFirst("The", "Those"));
    }
}
