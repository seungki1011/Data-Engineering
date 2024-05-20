package de.generic.constraint;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Vehicle {

    private String name;
    private int volume;

    public void move() {
        System.out.println("이동 수단 이동중.");
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                '}';
    }
}
