package de.java.construct;

public class Con2 {
    public static void main(String[] args) {
        // 사용자 정의 생성자가 존재하면 기본 생성자는 자동으로 생성 안됨
        // 무조건 직접 정의한 생성자를 호출해야 함(제약)
        // ProductInfo3 product1 = new ProductInfo3();
        ProductInfo3 product1 = new ProductInfo3("Chicken", 20000, 8.5);
        System.out.println("Name: " +product1.name+", Price: "+product1.price+", Rating: "+product1.rating);
    }
}
