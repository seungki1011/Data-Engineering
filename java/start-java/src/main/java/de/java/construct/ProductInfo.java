package de.java.construct;

public class ProductInfo {
    String name;
    int price;
    double rating;

    // 멤버 변수(인스턴스 변수)와 지역 변수 구분을 위해 this 사용
    void product(String name, int price, double rating){
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}
