package de.java.inheritance.practice;

public class Item {
    protected String name;
    protected int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public void print() {
        System.out.println("Name: "+name+", Price: "+price);
    }
    public int getPrice() {
        return price;
    }
}
