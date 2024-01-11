package de.java.polymorphism.interf;

public interface Fly { // 인터페이스는 class 대신 interface
    void move(); // 같은 메서드가 Move 인터페이스에도 존재, 다중 구현시 move()는 하나만 구현해도 됨
    void fly(); // 인터페이스는 메서드 앞에 자동으로 public abstract가 붙는다
}
