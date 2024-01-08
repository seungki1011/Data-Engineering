package de.java.polymorphism;

public class InstanceOfMain2 {
    public static void main(String[] args) {
        Parent p = new Parent();

        System.out.println("p instanceof Child : "+(p instanceof Child));
        System.out.println("new Parent() instanceof Child : "+(new Parent() instanceof Child));

        Child c = new Child();
        Parent p1 = c;

        System.out.println("new Child() instanceof Parent : "+(new Child() instanceof Parent));
        System.out.println("p1 instanceof Parent : "+(p1 instanceof Parent));
        System.out.println("p1 instanceof Child : "+(p1 instanceof Child));
        System.out.println("c instanceof Parent : "+(c instanceof Parent));
    }
}
