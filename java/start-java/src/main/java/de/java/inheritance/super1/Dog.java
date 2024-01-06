package de.java.inheritance.super1;

public class Dog extends Animal{
    public String name = "Dog";

    @Override
    public void eat() {
        System.out.println("Eating meat");
    }
    public void bark() {
        System.out.println("Barking. Bow wow!");
    }
    void call() {
        System.out.println("----------Check Variable Values-----------");
        System.out.println("this.name = "+this.name);
        System.out.println("super.name = "+super.name); // 부모 클래스인 Animal의 name 사용
        System.out.println("sound = "+sound);

        System.out.println("----------Call methods-----------");
        System.out.print("called this.eat() : ");
        this.eat();
        System.out.print("called super.eat() : ");
        super.eat(); // 부모 클래스인 Animal의 eat()를 호출
        System.out.print("called bark() : ");
        bark();
    }
}
