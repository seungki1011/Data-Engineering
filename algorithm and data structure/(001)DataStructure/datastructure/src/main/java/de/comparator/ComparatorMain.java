package de.comparator;

import de.comparable.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Amy", 50);
        Employee employee2 = new Employee("Bob", 30);
        Employee employee3 = new Employee("Cindy", 20);

        List<Employee> employees = new ArrayList<>(Arrays.asList(employee3, employee2, employee1));
        System.out.println("employees = " + employees);

        // Comparator를 이용한 정렬
        // id를 기준으로 오름차순 정렬
        employees.sort(new IdComparator());
        System.out.println("IdComparator() : " + employees);

        // 반대로 정렬
        employees.sort(new IdComparator().reversed());
        System.out.println("IdComparator().reversed() : " + employees);
    }
}
