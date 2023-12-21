package de.java.practice1;

import java.util.Scanner;

public class ptrc6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Start number : ");
        int startNum = scanner.nextInt();
        System.out.print("End number : ");
        int endNum = scanner.nextInt();

        for(int i=startNum; i<=endNum; i++){
            System.out.println(i);
        }
    }
}
