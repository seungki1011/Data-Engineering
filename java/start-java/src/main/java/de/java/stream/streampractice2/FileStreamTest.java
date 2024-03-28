package de.java.stream.streampractice2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStreamTest {
    public static void main(String[] args) {
        String filePath = "/Users/seungkikim/Desktop/Data-Engineering/java/start-java/src/main/java/de/java/stream/streampractice/testfile.txt";

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            // Stream processing
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
