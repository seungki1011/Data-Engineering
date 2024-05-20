package de.generic.box;

import de.generic.box.IntegerBox;
import de.generic.box.StringBox;

public class BoxMain1 {
    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox();
        integerBox.setValue(10);
        Integer i = integerBox.getValue();
        System.out.println("i = " + i);

        StringBox stringBox = new StringBox();
        stringBox.setValue("string value");
        String str = stringBox.getValue();
        System.out.println("str = " + str);
    }
}
