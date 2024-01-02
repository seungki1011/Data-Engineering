package de.java.accessmodifier.package2;

import de.java.accessmodifier.package1.Package1Data;

public class Package2Main {
    public static void main(String[] args) {
        Package1Data p = new Package1Data();
        p.publicMethod();

        // default(package-private)는 서로 다른 패키지에서 접근 불가능 (package2 -> package1)
        // p.defaultMethod();
        // p.privateMethod();

        p.innerAccess();
    }
}
