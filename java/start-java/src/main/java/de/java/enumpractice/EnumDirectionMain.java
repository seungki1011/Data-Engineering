package de.java.enumpractice;

public class EnumDirectionMain {
    public static void main(String[] args) {
        Direction dir; // 열거형 인스턴스 변수 선언

        dir = Direction.EAST;
        System.out.println(dir);

        dir = Direction.SOUTH;
        System.out.println(dir);

        // values() 사용해보기
        System.out.println("-----------values 사용해보기------------");
        Direction[] dArr = Direction.values();
        for (Direction direction : dArr) {
            System.out.println(direction);
        }
    }
}
