package de.java.variable;

public class VarType {
    public static void main(String[] args) {

        // Integer(정수형)
        int a = 99;
        // Long(정수형), Long은 뒤에 대문자 L 이용 권장
        long b = 888L;
        // Double(실수형)
        double c = 999.9d;
        // Boolean(논리형), true or false
        boolean d = true;
        // Character(문자 하나)
        char e = 'A';
        // String(문자열), 쌍따옴표
        String f = "This is a String";

        // 각 변수 출력
        System.out.println("int a : "+a);
        System.out.println("long b : "+c);
        System.out.println("double c : "+b);
        System.out.println("boolean d : "+d);
        System.out.println("char e : "+e);
        System.out.println("String f : "+false);

        // 숫자 자료형의 MinMax 출력
        System.out.println("Min of int : "+Integer.MIN_VALUE);
        System.out.println("Max of int : "+Integer.MAX_VALUE);

        System.out.println("Min of long : "+Long.MIN_VALUE);
        System.out.println("Max of long : "+Long.MAX_VALUE);

        System.out.println("Min of double : "+Double.MIN_VALUE);
        System.out.println("Max of double : "+Double.MAX_VALUE);

        /* ps.
        정수는 int, long
        실수는 double
        문자는 String 이용하자
         */

    }
}
