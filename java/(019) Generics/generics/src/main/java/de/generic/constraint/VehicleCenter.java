package de.generic.constraint;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VehicleCenter<T> {

    private T vehicle;

    public void check() {
        // object 타입의 메서드는 이용 가능
        System.out.println(vehicle.toString());

        // 특정 클래스의 메서드 사용 불가(컴파일 오류)
        // 타입은 객체 생성 순간 정해지기 때문에, 정해지기 전 시점에 메서드 사용 불가
        // System.out.println("이동 수단 연료양 = " + vehicle.getVolume());
        // vehicle.move();
    }

    public T getLargerVolume(T target) {
        // 마찬가지로 컴파일 오류
        // return vehicle.getVolume() > target.getVolume() ? vehicle : target;
        return null;
    }

}
