package de.java.construct;

public class Con3 {
    public static void main(String[] args) {
        // rating의 디폴트값이 7.0인 생성자 호출
        ProductInfo4 p = new ProductInfo4("Laptop", 1000000);
        // ProductInfo4 p = new ProductInfo4("Laptop", 1000000, 8.5); rating을 입력하면 rating까지 포함한 생성자 호출
        System.out.println("Product name: "+p.name+", Price: "+p.price+", Rating: "+p.rating);
    }
}
