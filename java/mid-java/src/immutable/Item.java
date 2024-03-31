package immutable;

public class Item {
    private String value = "";

    public Item(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value='" + value + '\'' +
                '}';
    }
}
