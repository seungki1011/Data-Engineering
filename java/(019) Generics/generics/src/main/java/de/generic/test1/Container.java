package de.generic.test1;

public class Container<T> {

    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public String isEmpty() {
        if (item == null) {
            return "true";
        }
        return "false";
    }
}
