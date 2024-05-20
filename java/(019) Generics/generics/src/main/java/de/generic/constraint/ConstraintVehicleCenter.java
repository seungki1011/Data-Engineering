package de.generic.constraint;

import lombok.AllArgsConstructor;


public class ConstraintVehicleCenter<T extends Vehicle> { // 타입 매개변수에 제약

    private T vehicle;

    public void setVehicle(T vehicle) {
        this.vehicle = vehicle;
    }

    public void check() {
        System.out.println(vehicle.toString());
        System.out.println("이동 수단 연료양 = " + vehicle.getVolume());
        vehicle.move();
    }

    public T getLargerVolume(T target) {
        return vehicle.getVolume() > target.getVolume() ? vehicle : target;
    }
}
