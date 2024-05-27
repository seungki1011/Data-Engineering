package de.iterable;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer> {

    private int currentIndex = -1;
    private int[] targetArr;

    public MyIterator(int[] targetArr) {
        this.targetArr = targetArr;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < targetArr.length - 1;
    }

    @Override
    public Integer next() {
        return targetArr[++currentIndex];
    }

}
