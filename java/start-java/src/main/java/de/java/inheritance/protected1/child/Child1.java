package de.java.inheritance.protected1.child;

import de.java.inheritance.protected1.parent.Parent;

public class Child1 extends Parent {
    public void callFromParent() {
        publicString = "This is a public string redefined in the Child1 class";
        protectedString = "This is a protected string redefined in the Child1 class";
        System.out.println(publicString);
        System.out.println(protectedString); // 서로 다른 패키지, 그러나 상속 관계라서 접근 가능

        // System.out.println(defaultString); // 서로 다른 패키지라서 접근 불가
        // System.out.println(privateString); // 서로 다른 클래스라서 접근 불가

        publicMethod();
        protectedMethod();

        insideParent();
    }
}
