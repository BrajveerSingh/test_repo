package com.dc.shopingbasket.cart;

import com.dc.shopingbasket.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest {

    @Test
    public void showCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Item.Apple);
        shoppingCart.add(Item.Apple);
        shoppingCart.add(Item.Banana);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Apple);
        shoppingCart.add(Item.Banana);
        shoppingCart.add(Item.Lime);
        List<String> expectedCart = List.of(
                "Apple",
                "Apple",
                "Banana",
                "Melon",
                "Apple",
                "Banana",
                "Lime"
        );
        assertThat(shoppingCart.showCart()).isEqualTo(expectedCart);
    }
}
