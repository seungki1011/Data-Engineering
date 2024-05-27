package de.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ComparableMain {
    public static void main(String[] args) {

        Employee employee1 = new Employee("김부장", 50);
        Employee employee2 = new Employee("박과장", 30);
        Employee employee3 = new Employee("최사원", 20);

        List<Employee> employees = new ArrayList<>(Arrays.asList(employee1, employee2, employee3));
        System.out.println("employees = " + employees);

        // Comparable을 이용한 디폴트 정렬
        // 이 경우에는 age를 기준으로 오름차순 정렬
        employees.sort(null);
        System.out.println("employees = " + employees);

    }
}
