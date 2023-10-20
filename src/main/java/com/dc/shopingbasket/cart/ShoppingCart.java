package com.dc.shopingbasket.cart;

import com.dc.shopingbasket.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCart {
    private final List<String> itemsBasket = new ArrayList<>();

    public synchronized void add(final Item item) {
        itemsBasket.add(item.name());
    }

    public synchronized void remove(final Item item) {
            itemsBasket.removeIf(shoppingItem -> shoppingItem.equals(item.name()));
    }

    public synchronized void remove(final List<Item> items) {
        items.forEach(this::remove);
    }

    public List<String> showCart(){
        return new ArrayList<>(itemsBasket);
    }
}
