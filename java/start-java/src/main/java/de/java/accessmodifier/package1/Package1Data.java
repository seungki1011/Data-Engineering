package de.java.accessmodifier.package1;

public class Package1Data {
    public int publicInt = 10;
    int defaultInt = 11;
    private int privateInt = 12;
    public String publicString = "This is a public String";
    String defaultString = "This is a package-private String";
    private String privateString = "This is a private String";

    public void publicMethod() {
        System.out.println("---------------------------------------------");
        System.out.println("1.public method is called");
        System.out.println("public Int = "+publicInt);
        System.out.println("public String = "+publicString);
    }
    private void privateMethod() {
        System.out.println("---------------------------------------------");
        System.out.println("3.private method is called");
        System.out.println("private Int = "+privateInt);
        System.out.println("private String = "+privateString);
    }
    void defaultMethod() {
        System.out.println("---------------------------------------------");
        System.out.println("2.package-private(default) method is called.");
        System.out.println("package-private(default) Int = "+defaultInt);
        System.out.println("package-private(default) String = "+defaultString);
    }
    public void innerAccess() {
        publicInt = 1;
        defaultInt = 2;
        // 같은 클래스의 필드에 접근 가능
        privateInt = 3;
        publicString = "This is a public String(Inner Access)";
        defaultString = "This is a package-private String(Inner Access)";
        privateString = "This is a private String(Inner Access)";
        publicMethod();
        defaultMethod();
        privateMethod();
    }
}
