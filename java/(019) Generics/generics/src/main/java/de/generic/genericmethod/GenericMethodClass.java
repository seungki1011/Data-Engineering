package de.generic.genericmethod;

import de.generic.constraint.Vehicle;
import lombok.Getter;
import lombok.Setter;


public class GenericMethodClass<T> {

    private T value;

    public static <V extends Vehicle> V staticGenericMethod1(V v) {
        //...
        return v;
    }

    // 제네릭 메서드의 T가 제네릭 클래스의 T보다 높은 우선순위를 가진다
    public <T extends Number> T instanceGenericMethod(T z) {
        //...
        return z;
    }

    // 인스턴스 메서드에는 제네릭 클래스의 타입 매개변수 사용 가능
    public T instanceGenericMethod2(T u) {
        return null;
    }

    // static 메서드에 제네릭을 사용하기 위해서는 제네릭 메서드 사용 필수
    // public static T staticGenericMethod2(T z) { return null; }

}
