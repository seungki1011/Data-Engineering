package de.java.staticvariable;

public class DataMain {
    public static void main(String[] args) {
        // 각 인스턴스를 새롭게 생성하고 인스턴스 멤버인 cnt를 접근하는 것(공유되지 않음!)
        Data1 d1 = new Data1("d1");
        System.out.println(d1.name+" count : "+d1.cnt);

        Data1 d2 = new Data1("d2");
        System.out.println(d2.name+" count : "+d2.cnt);

        Data1 d3 = new Data1("d3");
        System.out.println(d3.name+" count : "+d3.cnt);
    }
}
