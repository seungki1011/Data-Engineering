package de.map;

import java.util.HashMap;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {

        Map<String, Integer> studentGrades = new HashMap<>();

        // 해시맵에 엔트리 추가
        studentGrades.put("Alice", 90);
        studentGrades.put("Bob", 85);
        studentGrades.put("Charlie", 92);
        studentGrades.put("David", 88);

        // 출력
        printMap(studentGrades);

        // 특정키의 값 조회
        System.out.println("studentGrades.get('Charlie') = " + studentGrades.get("Charlie"));

        // 특정키의 유무 확인
        System.out.println("studentGrades.containsKey('Alice') = " + studentGrades.containsKey("Alice"));

        // 모든 Key 확인
        System.out.println("studentGrades.keySet() = " + studentGrades.keySet());

        // 모든 Value 확인
        System.out.println("studentGrades.values() = " + studentGrades.values());

        // 모든 Entry 확인
        System.out.println("studentGrades.entrySet() = " + studentGrades.entrySet());

        // 특정 엔트리 제거
        studentGrades.remove("Bob");
        studentGrades.remove("David");
        printMap(studentGrades);

    }

    private static void printMap(Map<String, Integer> map) {
        System.out.println("------printMap------");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("--------------------");
    }
}
