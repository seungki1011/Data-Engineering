package de.comparator;

import de.comparable.Employee;

import java.util.Comparator;

public class IdComparator implements Comparator<Employee> {

    // Employee의 객체의 id를 기준으로 오름차순 정렬
    // String 같은 클래스는 전부 compareTo() 같은 메서드들이 전부 구현되어 있다
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
