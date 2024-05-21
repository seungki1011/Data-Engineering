package de.generic.wildcard;

import de.generic.box.GenericBox;

public class NoConstraint {

    static <T> void printGeneric1(GenericBox<T> box) {
        System.out.println("[GenericBox<T> 사용] box.getValue() = " + box.getValue());
    }

    // 비제한 와일드 카드
    static void printWildcard1(GenericBox<?> box) {
        System.out.println("[GenericBox<?> 사용] box.getValue() = " + box.getValue());
    }
}
