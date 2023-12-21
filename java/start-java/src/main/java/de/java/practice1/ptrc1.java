package de.java.practice1;
import java.util.Scanner;

public class ptrc1 {
    public static void main(String[] args) {
        // scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter new text: ");
        String str = scanner.nextLine(); // 입력한 값을 string으로 가져오기
        System.out.println("The text you entered: " + str);

        System.out.print("Enter new Integer: ");
        int intVal = scanner.nextInt();
        System.out.println("The integer you entered: " + intVal);
    }
}
