package de.java.construct;

public class Con1 {
    public static void main(String[] args) {
        ProductInfo2 p = new ProductInfo2();
        p.product2("Pen",6000,9.0);
        System.out.println("Name: " +p.name+", Price: "+p.price+", Rating: "+p.rating);
    }
}
