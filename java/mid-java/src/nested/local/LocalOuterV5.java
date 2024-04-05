package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV5 {
    private int outInstanceVar = 3;

    public Printer process(int paramVar) {

        int localVar = 1;

        class LocalPrinter implements Printer {

            int value = 0;

            @Override
            public void print() {
                System.out.println("value=" + value);

                System.out.println("localVar=" + localVar);
                System.out.println("paramVar=" + paramVar);
                System.out.println("outInstanceVar=" + outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter();

//        localVar = 10;
//        paramVar = 20;

        return printer;
    }

    public static void main(String[] args) {
        LocalOuterV5 localOuter = new LocalOuterV5();
        Printer printer = localOuter.process(2);

        printer.print();

        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
    }
}


