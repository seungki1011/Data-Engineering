package de.java.staticvariable;

public class StaticDataMain {
    public static void main(String[] args) {
        // 인스턴스 참조 변수로 접근하는 것이 아니라 클래스명을 이용해서 접근
        StaticData1 d1 = new StaticData1("d1");
        System.out.println(d1.name+" count : "+StaticData1.cnt);

        StaticData1 d2 = new StaticData1("d2");
        System.out.println(d2.name+" count : "+StaticData1.cnt);

        // 인스턴스 참조 변수로 접근해도 가능은 하지만 권장하지 않음
        // 인스턴스 멤버에 cnt가 없는 것을 확인 -> 메서드 영역의 static 변수에서 확인
        StaticData1 d3 = new StaticData1("d3");
        System.out.println(d3.name+" count : "+d3.cnt);
    }
}
