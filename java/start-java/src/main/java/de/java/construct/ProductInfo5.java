package de.java.construct;

public class ProductInfo5 {
    String name;
    int price;
    double rating;

    // this()
    ProductInfo5(String name, int price){
        this(name, price, 7.0); // 아래의 생성자 호출
    }
    ProductInfo5(String name, int price, double rating){
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}
