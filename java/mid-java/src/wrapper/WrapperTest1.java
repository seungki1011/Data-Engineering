package wrapper;

public class WrapperTest1 {
    public static void main(String[] args) {
        Integer newInteger = new Integer(10); // deprecated, valueOf() 사용
        Integer integerObj = Integer.valueOf(10); // -128 ~ 127 캐싱

        Long longObj = Long.valueOf(100);
        Double doubleObj = Double.valueOf(0.5);

        System.out.println("newInteger = " + newInteger);
        System.out.println("integerObj = " + integerObj);
        System.out.println("longObj = " + longObj);
        System.out.println("doubleObj = " + doubleObj);

        System.out.println("--내부 값 읽기--");
        int intValue = integerObj.intValue();
        System.out.println("intValue = " + intValue);
        long longValue = longObj.longValue();
        System.out.println("longValue = " + longValue);

        System.out.println("--비교--");
        System.out.println("(newInteger == integerObj) = " + (newInteger == integerObj));
        System.out.println("newInteger.equals(integerObj) = " + newInteger.equals(integerObj));

    }
}
