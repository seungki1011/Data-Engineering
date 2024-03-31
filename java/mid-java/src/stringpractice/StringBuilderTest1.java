package stringpractice;

public class StringBuilderTest1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println("sb = " + sb);

        // 1. append() : 문자열 추가
        sb.append("H");
        sb.append("e");
        System.out.println("sb = " + sb);

        // 메서드를 체인해서 사용 가능
        sb.append("l")
                .append("l")
                .append("o");
        System.out.println("sb = " + sb);

        // 2. insert() : 특정 위치에 문자열 삽입
        sb.insert(5, " world!");
        System.out.println("--index 5에 \"world!\" 삽입--");
        System.out.println("sb = " + sb);

        // 3. delete() : 특점 범위의 문자열 삭제
        sb.delete(5, 12);
        System.out.println("--인덱스 5부터 11까지 삭제--");
        System.out.println("sb = " + sb);

        // 4. reverse() : 문자열 뒤집기
        sb.reverse();
        System.out.println("--문자열 뒤집기--");
        System.out.println("sb = " + sb);

        // 5. StringBuilder -> String
        String str = sb.toString();
        System.out.println("str = " + str);

    }
}
