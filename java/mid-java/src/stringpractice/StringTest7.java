package stringpractice;

public class StringTest7 {
    public static void main(String[] args) {
        String str = "Apple,Banana,Orange";

        // 1. split() - 주어진 정규 표현식 기준으로 분할
        String[] splitStr = str.split(","); // "," 구분자를 기준으로 문자열 분할

        for(String s : splitStr) {
            System.out.println(s);
        }

        // 2. join() - 주어진 구분자로 문자열 결합
        String joinedStr = String.join("-", "A", "B", "C"); // "-" 구분자로 결합
        System.out.println("연결된 문자열: " + joinedStr);

        // 문자열 배열 연결
        String result = String.join("-", splitStr);
        System.out.println("result = " + result);
    }
}
