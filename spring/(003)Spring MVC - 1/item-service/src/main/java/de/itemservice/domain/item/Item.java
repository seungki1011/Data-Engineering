package de.itemservice.domain.item;

import lombok.Data;

@Data // Getter, Setter, toString 등 다 만들어줌(권장 x, 위험하다! 그냥 @Getter, @Setter 사용 좋음)
public class Item {
    private Long id;
    private String itemName;
    private Integer price; // Integer 사용 이유는 price가 null로 들어갈 가능성
    private Integer quantity;

    public Item() {

    }
    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
