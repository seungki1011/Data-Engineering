package de.java.accessmodifier.package1;

public class Package1Main {
    public static void main(String[] args) {
        Package1Data p = new Package1Data();
        p.publicMethod();
        p.defaultMethod();

        // private method를 다른 클래스(Package1Main -> Package1Data)에서 접근 하면 에러 발생
        // error: privateMethod() has private access in de.java.accessmodifier.package1.Package1Data
        // p.privateMethod();

        p.innerAccess();
    }
}
