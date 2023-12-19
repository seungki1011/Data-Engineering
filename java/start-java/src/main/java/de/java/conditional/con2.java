package de.java.conditional;

public class con2 {
    public static void main(String[] args) {
        // switch
        int choice = 2;

        switch (choice) { // choice에 조건식이 들어간다. 케이스의 값과 조건식의 값이 일치해야 해당 케이스의 코드 실행
            case 1:
                System.out.println("You chose option 1!");
                break; // exit switch block with break
            case 2:
                System.out.println("You chose option 2!");
                break;
            case 3:
                System.out.println("You chose option 3!");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        System.out.println("This is the remaining code executed after the switch block");
    }
}
