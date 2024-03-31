package objectpractice;

class Item {
    String name = "Im a item";

    void itemMethod() {
        System.out.println("---itemMethod() called---");
    }

    @Override
    public String toString() {
        return "item" + "={ name : " + name + " }";
    }
}
