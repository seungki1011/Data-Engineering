package de.java.stream.streampractice4;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        // Create an Optional with a non-null value
        Optional<String> optionalWithValue = Optional.ofNullable("Hello");

        // Create an Optional with a null value
        Optional<String> optionalWithNull = Optional.ofNullable(null);

        // Check if the optional has a value
        if (optionalWithValue.isPresent()) {
            System.out.println("Value is present: " + optionalWithValue.get());
        } else {
            System.out.println("No value present");
        }

        // Check if the optional with null has a value
        if (optionalWithNull.isPresent()) {
            System.out.println("Value is present: " + optionalWithNull.get());
        } else {
            System.out.println("No value present");
        }
    }
}
