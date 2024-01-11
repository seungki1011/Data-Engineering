package de.java.polymorphism.interf;

public abstract class Vehicle{
    // 추상 메서드
    public abstract void fillUp();
    public abstract void showName();

    // 일반 메서드
    public void useHonk() {
        System.out.println("Used Honk! Bing Bong~");
    }
}
