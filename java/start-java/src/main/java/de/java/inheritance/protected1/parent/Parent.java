package de.java.inheritance.protected1.parent;

public class Parent {
    public String publicString = "This is a public string in the parent package";
    protected String protectedString = "This is a protected string in the parent package";
    private String privateString = "This is a private string in the parent package";
    String defaultString = "This is a default(package-private) string in the parent package";

    public void publicMethod() {
        System.out.println("Public method in the parent package, parent class.");
    }
    protected void protectedMethod() {
        System.out.println("Protected method in the parent package, parent class.");
    }
    private void privateMethod() {
        System.out.println("Private method in the parent package, parent class.");
    }
    void defaultMethod() {
        System.out.println("Default(package-private) method in the parent package, parent class.");
    }
    public void insideParent() {
        System.out.println("-----Inside Parent class which is inside the parent package-----");
        System.out.println("publicString = "+publicString);
        System.out.println("protectedString = "+protectedString);
        System.out.println("defaultString = "+defaultString);
        System.out.println("privateString = "+privateString);
        publicMethod();
        protectedMethod();
        defaultMethod();
        privateMethod();
    }
}
