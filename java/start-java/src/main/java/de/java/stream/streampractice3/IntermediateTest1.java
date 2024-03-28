package de.java.stream.streampractice3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class IntermediateTest1 {
    public static void main(String[] args) {
        String[] strArr = {"a", "b", "c", "d", "e", "f"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strArr));

        // 1. skip
        Stream<String> strStream1 = Arrays.stream(strArr)
                        .skip(2);
        strStream1.forEach(System.out::print); //cdef
        System.out.println();

        // 2. limit
        Stream<String> strStream2 = Arrays.stream(strArr)
                        .limit(2);
        strStream2.forEach(System.out::print); // ab
    }
}
