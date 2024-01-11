package de.java.polymorphism.polyusage;

public class UsePolyMain1 {
    public static void main(String[] args) {
        /*
      	Animal dog = New Dog();
      	Animal cat = New Cat();
      	Animal cow = New Cow();
      	*/
        // 배열로 리펙토링
        Animal[] animalArray = new Animal[] {new Dog(), new Cat(), new Cow()};

        // 다형성 없이 코드 작성 했다면 각 동물마다 똑같이 반복되는 코드를 작성해서 사용했어야함
      	/*
      	System.out.println("--------Animal Sound Start!--------");
        cat.getName();
        cat.sound();
        System.out.println("---------Animal Sound End!---------");
      	*/
        for (Animal animal : animalArray) {
            makeAnimalSound(animal);
        }
    }

    private static void makeAnimalSound(Animal animal) {
        System.out.println("--------Animal Sound Start!--------");
        animal.getName();
        animal.sound();
        System.out.println("---------Animal Sound End!---------");
    }
}
