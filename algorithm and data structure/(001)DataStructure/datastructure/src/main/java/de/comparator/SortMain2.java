package de.comparator;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.*;

public class SortMain2 {
    public static void main(String[] args) {

        Integer[] array = {2, 1, 3, 4};
        System.out.println("array = " + Arrays.toString(array));

        // 오름차순 정렬
        Arrays.sort(array);
        System.out.println(".sort(array) : " + Arrays.toString(array));

        // 내림차순 정렬
        Arrays.sort(array, reverseOrder());
        System.out.println(".sort(array, Comparator.reverseOrder()) : " + Arrays.toString(array));
    }
}
