package system;

import java.util.Arrays;
import java.util.Map;

public class SystemTest1 {
    public static void main(String[] args) {

        // 현재 시간 (milli second)
        long currentTimeMs = System.currentTimeMillis();
        System.out.println("(밀리초)currentTimeMs = " + currentTimeMs);

        // 현재 시간 (nano second)
        long currentItemNs = System.nanoTime();
        System.out.println("(나노초)currentItemNs = " + currentItemNs);

        // 환경 변수 읽기
        Map<String, String> getEnv = System.getenv();
        System.out.println("getEnv = " + getEnv);

        // 시스템 속성 읽기
        System.out.println("properties = " + System.getProperties());
        System.out.println("Java Version = " + System.getProperty("java.version"));

        // 배열 빠르게 복사
        char[] originalArray = {'J', 'A', 'V', 'A', '!'};
        char[] copiedArray = new char[5];

        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);

        System.out.println("copiedArray = " + copiedArray);
        System.out.println("Arrays.toString(copiedArray) = " + Arrays.toString(copiedArray));

        // 프로그램 종료
        System.exit(0);

    }
}
