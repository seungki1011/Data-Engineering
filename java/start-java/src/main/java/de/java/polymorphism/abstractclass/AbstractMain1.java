package de.java.polymorphism.abstractclass;


public class AbstractMain1 {
    public static void main(String[] args) {

        Animal[] animalArray = new Animal[] {new Dog(), new Cat(), new Pig()};

        for (Animal animal : animalArray) {
            makeAnimalSound(animal);
        }
    }

    private static void makeAnimalSound(Animal animal) {
        System.out.println("--------Animal Sound Start!--------");
        animal.move();
        animal.makeSound();
        System.out.println("---------Animal Sound End!---------");
    }
}
