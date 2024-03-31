package objectpractice;


public class ObjectTest1 {
    public static void main(String[] args) {

        Item item = new Item();
        Person person = new Person();
        Object object = new Object();

        Object[] objects = {item, person, object};

        size(objects);

        System.out.println(objects[0].toString());
        System.out.println(item.toString());

        item.itemMethod();
        person.personMethod();

    }

    private static void size(Object[] objects) {
        System.out.println("The number of objects : " + objects.length);
    }
}
