package de.java.inheritance.extend1;

public class Car extends Vehicle {
    // 기존에 사용하던 move()를 부모 클래스로 옮기고, 자식 클래스가 상속 받을수 있도록 한다
    public void move() {
        System.out.println("The car is currently moving on ground!");
    }

}
