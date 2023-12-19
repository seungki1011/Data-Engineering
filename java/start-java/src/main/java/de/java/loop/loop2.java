package de.java.loop;

public class loop2 {
    public static void main(String[] args) {
        // 1. do-while 1
        int cnt = 0;
        do {
            cnt++;
            System.out.println("cnt is " + cnt);
        } while(cnt < 3);

        // 2. do-while 2
        int i = 3;
        do {
            System.out.println("do will execute first");
        } while(i < 2);
    }
}
