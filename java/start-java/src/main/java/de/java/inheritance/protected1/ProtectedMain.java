package de.java.inheritance.protected1;

import de.java.inheritance.protected1.child.Child1;
import de.java.inheritance.protected1.parent.Parent;

public class ProtectedMain {
    public static void main(String[] args) {
        Child1 c1 = new Child1();
        c1.callFromParent();

        Parent p1 = new Parent();
        p1.insideParent();
    }
}
