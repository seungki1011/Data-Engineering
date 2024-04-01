package enumeration;

import java.util.Arrays;

public class EnumMethod {
    public static void main(String[] args) {

        // 모든 Enum 반환
        Direction[] values = Direction.values();
        System.out.println("values = " + Arrays.toString(values));
        for (Direction value : values) {
            System.out.println("[name = " + value.name() + ", ordinal = " + value.ordinal() + "]");
        }

        // String -> Enum
        String input = "NORTH";
        Direction north = Direction.valueOf(input);
        System.out.println("north = " + north); // toString() 오버라이딩 가능

    }
}
