package stringpractice;

public class StringTest4 {
    public static void main(String[] args) {
        String str = "As the sun dipped below the horizon, painting the sky in hues of orange and pink," +
                " a sense of serenity washed over the tranquil seaside village of Polppero.";

        System.out.println("문자열에 'tranquil'가 포함되어 있나요? =  " + str.contains("tranquil"));
        System.out.println("첫 번째 'sum'이 등장하는 인덱스: " + str.indexOf("sun"));
        System.out.println("인덱스 5부터 'sun'의 인덱스: " + str.indexOf("sun", 5));
        System.out.println("인덱스 10부터 'sun'의 인덱스: " + str.indexOf("sun", 10));
        System.out.println("'the'의 마지막 인덱스: " + str.lastIndexOf("the"));

    }
}
