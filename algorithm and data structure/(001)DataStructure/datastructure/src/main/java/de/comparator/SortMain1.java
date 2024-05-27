package de.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class SortMain1 {
    public static void main(String[] args) {

        Integer[] array = {4, 3, 2, 1};

        System.out.println("array = " + Arrays.toString(array));

        // AscComparator를 제공해서 오름차순 정렬
        Arrays.sort(array, new AscComparator());
        System.out.println("AscComparator : " + Arrays.toString(array));

        // DescComparator를 제공해서 내림차순 정렬
        Arrays.sort(array, new DescComparator());
        System.out.println("DescComparator : " + Arrays.toString(array));

        // AscComparator.reversed()를 사용해서 내림차순 정렬 가능
        array = new Integer[]{4, 3, 2, 1};
        Arrays.sort(array, new AscComparator().reversed());
        System.out.println("AscComparator().reversed() : " + Arrays.toString(array));
    }

    // 오름차순 정렬을 위한 Comparator 구현
    static class AscComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            // System.out.println("o1 = " + o1 + ", o2 = " + o2);
            return (o1 < o2) ? -1 : ((o1.equals(o2)) ? 0 : 1);
        }
    }

    // 내림차순 정렬을 위한 Comparator 구현
    static class DescComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            // System.out.println("o1 = " + o1 + ", o2 = " + o2);
            return (o1 < o2) ? -1 : ((o1.equals(o2)) ? 0 : 1) * -1;
        }
    }

}
