package de.java.classpractice;

public class cp1 {
    public static void main(String[] args) {
        Customer customer1;
        // 실제 메모리에 생성
        customer1 = new Customer();

        customer1.name = "Alex";
        customer1.gender = "Male";
        customer1.age = 25;
        customer1.point = 60000;

        Customer customer2 = new Customer();
        customer2.name = "Jane";
        customer2.gender = "Female";
        customer2.age = 22;
        customer2.point = 80000;

        System.out.println("Name: "+customer1.name+", Age: "+customer1.age+", Points: "+customer1.point);
        System.out.println("Name: "+customer2.name+", Age: "+customer2.age+", Points: "+customer2.point);
    }
}
