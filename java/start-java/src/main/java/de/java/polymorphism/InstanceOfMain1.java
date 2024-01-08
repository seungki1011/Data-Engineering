package de.java.polymorphism;

public class InstanceOfMain1 {
    public static void main(String[] args) {
        Parent poly1 = new Parent();
        Parent poly2 = new Child();
        Parent poly3 = new GrandChild();
        Child poly4 = new GrandChild();
        Child poly5 = new Child();

        System.out.print("Is poly1 a instance of Child? : "+(poly1 instanceof Child)+"\n");
        call(poly1); // Child 인스턴스 x
        System.out.println("--------------------------");
        System.out.print("Is poly2 a instance of Child? : "+(poly2 instanceof Child)+"\n");
        call(poly2); // Child 인스턴스 o
        System.out.println("--------------------------");
        System.out.print("Is poly3 a instance of Child? : "+(poly3 instanceof Child)+"\n");
        call(poly3); // Child 인스턴스 o
        System.out.println("--------------------------");
        System.out.print("Is poly4 a instance of GrandChild? : "+(poly4 instanceof GrandChild)+"\n");
        call(poly4); // Child 인스턴스 o
        System.out.println("--------------------------");
        System.out.print("Is poly5 a instance of GrandChild? : "+(poly5 instanceof GrandChild)+"\n");
    }

    private static void call(Parent parent) {
        if (parent instanceof Child) {
            System.out.println("It is a instance of Child!");
            // 만약 parent가 Child의 인스턴스가 맞다면 다운캐스팅 가능
            Child child = (Child) parent;
            child.childMethod();
        } else {
            System.out.println("It is not a instance of Child!");
        }
    }
}
