package com.dc.shopingbasket.offer;

import com.dc.shopingbasket.Item;
import com.dc.shopingbasket.billing.ItemPrice;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component
public class ItemOfferManager {
    private Map<String, String> offer;

    public ItemOfferManager() {
        offer = Map.of(
                Item.Melon.name(), "buy one get one free",
                Item.Lime.name(), "three for the price of two"
        );
    }

    public String getOffer(Item item) {
        return offer.getOrDefault(item.name(), "");
    }

    public Collection<String> showAllOffer() {
        return offer.values();
    }

    public int applyOffer(Map<String, Integer> quantityByItem, ItemPrice itemPrice) {
        int discount = 0;
        for (String item : quantityByItem.keySet()) {
            int pricePerItem = itemPrice.getPrice(item);
            int quantity = quantityByItem.get(item);
            if (Item.Melon.name().equalsIgnoreCase(item)) {
                if (quantity > 1) {
                    discount += (quantity / 2) * pricePerItem;
                }
            }
            if (Item.Lime.name().equalsIgnoreCase(item)) {
                if (quantity > 2) {
                    int division = quantity / 3;
                    discount += division * pricePerItem;
                }
            }
        }
        return discount;
    }
}
