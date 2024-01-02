package de.java.accessmodifier.practice2;

import de.java.accessmodifier.practice1.Item;
import de.java.accessmodifier.practice1.ShoppingCart;

public class ShoppingMain {
    public static void main(String[] args) {
        ShoppingCart c = new ShoppingCart();
        Item item1 = new Item("Chicken", 20000, 6);
        Item item2 = new Item("Cola", 2500, 4);
        Item item3 = new Item("Pizza", 32500, 2);
        Item item4 = new Item("MakGukSu", 11000, 1);
        Item item5 = new Item("Hamburger", 3000 , 15);

        c.addItem(item1);
        c.addItem(item2);
        c.addItem(item3);
        c.addItem(item4);
        c.addItem(item5);
        c.displayItems();
    }
}
