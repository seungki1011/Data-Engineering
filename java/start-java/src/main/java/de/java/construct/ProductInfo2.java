package de.java.construct;

public class ProductInfo2 {
    String name;
    int price;
    double rating;

    // 1. this의 사용이 강제는 아님
    // 2. 멤버변수라는 것을 나타내기 위해 this를 붙여서 사용해도 동작
    void product2(String productName, int productPrice, double productRating){
        name = productName;
        price = productPrice;
        rating = productRating;

        /*
        this.name = productName;
        this.price = productPrice;
        this.rating = productRating;
         */
    }
}
