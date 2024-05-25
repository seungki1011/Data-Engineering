package de.set;

public class SetMain1 {
    public static void main(String[] args) {

        // 우리가 구현한 세트 사용
        NoHashMySet set = new NoHashMySet();

        // 세트에 값 추가
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        // 중복된 값 추가시 false 반환
        System.out.println("set.add(4) = " + set.add(4));
        System.out.println(set);

        // 세트 내부에 값이 있는지 확인
        System.out.println("set.contains(2) = " + set.contains(2));

    }
}
