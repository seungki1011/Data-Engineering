package de.java.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        // HashMap 생성 - student(key) : grade(value)
        Map<String, Integer> studentGrades = new HashMap<>();

        // 1. put() - Add entries to the HashMap
        studentGrades.put("Alice", 90);
        studentGrades.put("Bob", 85);
        studentGrades.put("Charlie", 92);
        studentGrades.put("David", 88);

        // 2. HashMap의 Key-Value 출력해보기
        System.out.println("-----------print entries of HashMap------------");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println("Key: "+entry.getKey()+", Value: "+entry.getValue());
        }

        // 2. get() - Retrieve the grade for a specific student
        System.out.println("-------retrieve value of a specific key--------");
        int charlieGrade = studentGrades.get("Charlie");
        System.out.println("Charlie's Grade: " + charlieGrade);

        // 3. containsKey() - Check if the HashMap contains a specific key
        System.out.println("-----------------------------------------------");
        boolean hasAlice = studentGrades.containsKey("Alice");
        System.out.println("Does it contain Alice?: " + hasAlice);

        // 4. size() - Get the number of entries in the HashMap
        int numberOfStudents = studentGrades.size();
        System.out.println("Number of Students: " + numberOfStudents);

        // 5. keySet() - Get a set of all keys in the HashMap
        System.out.println("Students: " + studentGrades.keySet());

        // 6. values() - Get a collection of all values in the HashMap
        System.out.println("Grades: " + studentGrades.values());

        // 7. entrySet() - Get a set of key-value pairs (entries) in the HashMap
        System.out.println("Entries: " + studentGrades.entrySet());

        // 8. remove() - Remove a specific entry from the HashMap
        studentGrades.remove("Bob");
        System.out.println("HashMap after removing Bob: " + studentGrades);

        // 9. clear() - Remove all entries from the HashMap
        studentGrades.clear();
        System.out.println("HashMap after clearing: " + studentGrades);
    }
}
