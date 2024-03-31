package objectpractice;

public class ObjectTest3 {
    public static void main(String[] args) {

        Item item = new Item();
        Person person = new Person();
        Object object = new Object();

        Object[] objects = {item, person, object};


        System.out.println(objects[0].toString());
        System.out.println(objects[0]); // println(objects[0].toString())와 동일

        System.out.println(item.toString());
        System.out.println(item); // println(item.toString())와 동일

        item.itemMethod();
        person.personMethod();
    }
}
