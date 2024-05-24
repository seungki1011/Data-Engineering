package de.array;

import java.util.Arrays;

public class ArrayMain {
    public static void main(String[] args) {

        int[] arr = new int[5];

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 5;
        // 배열 출력 - [1, 2, 5, 0, 0]
        System.out.println("arr = " + Arrays.toString(arr));

        // 첫 번째 인덱스에 값 밀어 넣기
        addFirst(arr, 99);
        System.out.println("arr = " + Arrays.toString(arr));

        // 마지막 인덱스에 값 넣기
        addLast(arr, 10);
        System.out.println("arr = " + Arrays.toString(arr));

        // 2번 인덱스에 값 넣기
        addAtIndex(arr, 2, 200);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    private static void addLast(int[] arr, int newValue){
        arr[arr.length - 1] = newValue;
    }

    private static void addFirst(int[] arr, int newValue) {
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = newValue;
    }

    private static void addAtIndex(int[] arr, int index, int newValue) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = newValue;
    }
}
