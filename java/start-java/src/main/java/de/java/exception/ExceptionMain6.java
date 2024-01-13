package de.java.exception;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionMain6 {
    public static void main(String[] args) {
        FileWriter f = null;

        try {
            f = new FileWriter("data.txt");
            System.out.println("Writing data to data.txt!");
            f.write("Hello World!");
            // f.close(); // 위에서 예외가 발생하면 close가 실행되지 않는 문제가 발생
            // -> close를 finally에서 실행하도록 함
        } catch (IOException e) {
            System.out.println("Handle IOException : "+e.getMessage());
        } finally {
            System.out.println("[finally block] 아래 코드는 항상 실행");
            if(f != null) { // f가 null이 아니라면
                try {
                    f.close();
                } catch (IOException e) {
                    System.out.println("Handle IOException(for f.close()) : "+e.getMessage());
                }
            } else {
                System.out.println("f is null");
            }
        }
    }
}
