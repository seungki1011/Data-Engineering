package de.java.array;
import java.util.Arrays;

public class arr1 {
    public static void main(String[] args) {
        // 1. 배열 선언
        int[] newArray = new int[3]; // int형 변수를 3개 담을 수 있는 배열 선언과 생성
        /*
        int[] newArray; (배열 변수 선언)
        newArray = new int[3]; (배열 생성)
         */
        System.out.println("배열 참조값: "+newArray);
        System.out.println("배열: "+Arrays.toString(newArray)); // int의 디폴트값인 0으로 채워진 배열

        // 2. 배열 선언 - 선언과 동시에 초기화
        int[] newArray2 = new int[] {400,421,534,212,2342};
        for(int i = 0; i < 5; i++){
            System.out.println(i+"번 인덱스의 배열값: "+newArray2[i]);
        }

        String[] names = {"Andy", "Caillou", "Alex", "Shelby"};
        System.out.println(Arrays.toString(names));
    }
}
