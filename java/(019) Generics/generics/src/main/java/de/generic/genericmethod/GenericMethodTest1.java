package de.generic.genericmethod;

public class GenericMethodTest1 {
    public static void main(String[] args) {

        Integer i = 100;
        Object object = GenericMethod.objMethod(i);

        // 타입 인자 명시
        Integer result = GenericMethod.<Integer>genericMethod(i);
        Integer integerValue = GenericMethod.<Integer>numberMethod(100);
        // <Double>(타입 인자) 생략 가능
        Double doubleValue = GenericMethod.numberMethod(200.0);

    }
}
