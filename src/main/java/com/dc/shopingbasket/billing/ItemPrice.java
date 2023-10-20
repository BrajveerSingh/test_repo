package com.dc.shopingbasket.billing;

import com.dc.shopingbasket.Item;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ItemPrice {
    private final Map<Item, Integer> priceByItem;

    public ItemPrice(){
        priceByItem = Map.of(
                Item.Apple, 35,
                Item.Banana,20,
                Item.Melon, 50,
                Item.Lime, 15
        );
    }

    public int getPrice(String item){
        return switch (item) {
            case "Apple" -> priceByItem.get(Item.Apple);
            case "Banana" -> priceByItem.get(Item.Banana);
            case "Melon" -> priceByItem.get(Item.Melon);
            case "Lime" -> priceByItem.get(Item.Lime);
            default -> throw new RuntimeException("Item:" + item + " not supported.");
        };
    }

    public String checkPrice(String item){
        return switch (item) {
            case "Apple" -> String.format("Apples are %sp each", priceByItem.get(item));
            case "Banana" -> String.format("Bananas are %sp each", priceByItem.get(item));
            case "Melon" -> String.format("Melons are %sp each", priceByItem.get(item));
            case "Lime" -> String.format("Limes are %sp each", priceByItem.get(item));
            default -> throw new RuntimeException("Item:" + item + " not supported.");
        };
    }

}
