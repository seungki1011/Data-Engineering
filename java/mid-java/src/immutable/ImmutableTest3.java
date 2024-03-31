package immutable;

public class ImmutableTest3 {
    public static void main(String[] args) {
        ImmutableItem item1 = new ImmutableItem("치킨");
        ImmutableItem item2 = item1; // 참조값 대입을 막을 방법은 없다

        System.out.println("item1 : "+item1);
        System.out.println("item2 : "+item2);

        System.out.println("item2 = new ImmutableItem(\"피자\");");
        // item2.setValue("B");
        item2 = new ImmutableItem("피자");
        System.out.println("item1 : "+item1); // 사이드 이펙트 발생, A -> B
        System.out.println("item2 : "+item2);
    }
}
