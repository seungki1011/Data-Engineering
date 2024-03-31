package wrapper;

public class WrapperTest2 {
    public static void main(String[] args) {

        // 1. Auto-boxing : Primitive -> Wrapper
        int value = 10;
        Integer boxedValue = value;

        // 2. Auto-unboxing : Wrapper -> Primitive
        int unboxedValue = boxedValue;

        System.out.println("boxedValue = " + boxedValue);
        System.out.println("unboxedValue = " + unboxedValue);

    }
}
