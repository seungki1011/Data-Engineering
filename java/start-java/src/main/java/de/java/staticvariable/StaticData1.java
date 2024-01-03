package de.java.staticvariable;

public class StaticData1 {
    public String name;
    public static int cnt; // static 붙음

    public StaticData1(String name) {
        this.name = name;
        // 원래는 StaticData1.cnt++; 으로 static 변수를 사용하지만
        // 같은 클래스 내에서는 생략 가능
        cnt++;
    }
}
