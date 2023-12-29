package de.java.construct;

public class ProductInfo4 {
    String name;
    int price;
    double rating;

    // 생성자 Overloading
    ProductInfo4(String name, int price){// rating 입력 없이 생성자 이용시 이 생성자 호출
        this.name = name;
        this.price = price;
        this.rating = 7.0;
    }
    ProductInfo4(String name, int price, double rating){
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}
