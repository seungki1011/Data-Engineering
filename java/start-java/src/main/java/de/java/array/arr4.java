package de.java.array;

import java.util.Scanner;

public class arr4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] scores = new int[4][3];

        // 과목도 배열로 처리해서 ㄱㄱ
        for(int i = 0; i < 4; i++){
            System.out.println("Enter student " + (i+1) + " scores");
            for(int j = 0; j < 3; j++) {
                if (j==0) {
                    System.out.print("Literature: ");
                } else if (j==1) {
                    System.out.print("English: ");
                } else {
                    System.out.print("Math: ");
                }
                scores[i][j] = input.nextInt();
            }
        }

        for(int i = 0; i < 4; i++){
            int sum = 0;
            for(int j = 0; j < 3; j++) {
                sum += scores[i][j];
            }
            System.out.println("Student " + (i+1) + " Total score: " + sum);
        }
    }
}
