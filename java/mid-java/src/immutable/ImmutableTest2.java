package immutable;

public class ImmutableTest2 {
    public static void main(String[] args) {
        Item item1 = new Item("치킨");
        Item item2 = item1;

        System.out.println("item1 : "+item1);
        System.out.println("item2 : "+item2);

        System.out.println("item2.setValue(\"피자\");");
        item2.setValue("피자");
        System.out.println("item1 : "+item1); // 사이드 이펙트 발생, A -> B
        System.out.println("item2 : "+item2);
    }
}
