package de.java.practice1;
import java.util.Scanner;

public class ptrc7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the numbers. Enter -1 to calculate.");
        int sum = 0;
        int cnt = 0;
        int intVal = 0;

        while (true) {
            intVal = input.nextInt();
            if (intVal==-1){
                break;
            }
            cnt++;
            sum += intVal;
        }
        double avg = (double) sum / cnt;
        System.out.println("Sum is "+sum);
        System.out.println("Average is "+avg);
    }
}
