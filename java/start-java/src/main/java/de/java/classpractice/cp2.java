package de.java.classpractice;

public class cp2 {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        customer1.name = "Alex";
        customer1.gender = "Male";
        customer1.age = 25;
        customer1.point = 60000;

        Customer customer2 = new Customer();
        customer2.name = "Jane";
        customer2.gender = "Female";
        customer2.age = 22;
        customer2.point = 80000;

        // 1. 객체 배열 생성
        Customer[] customers = new Customer[2]; // 참조 변수 customer1,2를 담기 위해 길이 2

        // 2. 객체 배열 초기화
        customers[0] = customer1;
        customers[1] = customer2;
        // Customer[] customers = new Customer[]{customer1, customer2};

        System.out.println("Name: "+customers[0].name+", Age: "+customers[0].age+", Points: "+customers[0].point);
        System.out.println("Name: "+customers[1].name+", Age: "+customers[1].age+", Points: "+customers[1].point);
    }
}
