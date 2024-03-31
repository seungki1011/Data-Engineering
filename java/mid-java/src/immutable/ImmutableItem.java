package immutable;

public class ImmutableItem {
    private final String value; // final : 한번 생성하고 값을 변경하는 것 불가
    // 사실 final을 사용하지 않아도 setValue가 없으면 값을 변경하는 것은 불가

    public ImmutableItem(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value='" + value + '\'' +
                '}';
    }
}
