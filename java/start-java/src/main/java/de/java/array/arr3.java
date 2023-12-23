package de.java.array;

import java.util.Scanner;

public class arr3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Number of integers: ");
        int numInt = input.nextInt();

        int[] numArray = new int[numInt];
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        System.out.println("Enter "+numInt+" integers: ");
        for (int i = 0; i < numInt; i++){
            numArray[i] = input.nextInt();
            if(maxNum<numArray[i]){
                maxNum = numArray[i];
            }
            if(minNum>numArray[i]){
                minNum = numArray[i];
            }
        }
        System.out.println("Max number is "+maxNum);
        System.out.println("Min number is "+minNum);
    }
}
