package de.comparable;

public class Employee implements Comparable<Employee> {

    private String id;
    private int age;

    public Employee(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    // Comparable 구현 - age를 기준으로 오름차순 정렬
    @Override
    public int compareTo(Employee o) {
        return this.age < o.age ? -1 : (this.age == o.age ? 0 : 1);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
