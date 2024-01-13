package de.java.exception;


import java.io.FileWriter;
import java.io.IOException;

public class ExceptionMain7 {
    public static void main(String[] args) {
        try (FileWriter f = new FileWriter("Data2.txt")) {
            System.out.println("Writing data to Data2.txt!");
            f.write("Hello World2!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
