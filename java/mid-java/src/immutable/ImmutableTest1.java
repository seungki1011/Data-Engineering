package immutable;

public class ImmutableTest1 {
    public static void main(String[] args) {

        int a = 5;
        System.out.println("a = " + a); // a = 5

        int b = a;
        System.out.println("b = " + b); // b = 5

        b = 50;
        System.out.println("b에 50 대입");
        System.out.println("b = " + b); // b = 50

    }
}
