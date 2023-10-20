package com.dc.shopingbasket.billing;

import com.dc.shopingbasket.Item;
import com.dc.shopingbasket.cart.ShoppingCart;
import com.dc.shopingbasket.offer.ItemOfferManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BillCalculatorTest {
    @Autowired
    private ItemPrice itemPrice;
    @Autowired
    private ItemOfferManager offerManager;

    @Test
    public void getBillWhen1LimeAnd1Melon() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Item.Apple);
        shoppingCart.add(Item.Banana);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Lime);
        BillCalculator billCalculator = new BillCalculator(shoppingCart, itemPrice, offerManager);
        int bill = billCalculator.getBill();
        int expectedPrice =
                itemPrice.getPrice(Item.Apple.name())
                + itemPrice.getPrice(Item.Banana.name())
                + itemPrice.getPrice(Item.Melon.name())
                + itemPrice.getPrice(Item.Lime.name());
        assertThat(expectedPrice).isEqualTo(bill);
    }

    @Test
    public void getBillWhen3LimeAnd5Melon() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Item.Apple);
        shoppingCart.add(Item.Banana);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Lime);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Lime);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Lime);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Melon);
        BillCalculator billCalculator = new BillCalculator(shoppingCart, itemPrice, offerManager);
        int bill = billCalculator.getBill();
        int expectedPrice =
                itemPrice.getPrice(Item.Apple.name())
                        + itemPrice.getPrice(Item.Banana.name())
                        + (3 * itemPrice.getPrice(Item.Melon.name()))
                        + (2 * itemPrice.getPrice(Item.Lime.name()));
        assertThat(expectedPrice).isEqualTo(bill);
    }

    @Test
    public void getBillWhen3LimeAnd10Melon() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Item.Apple);
        shoppingCart.add(Item.Banana);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Lime);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Lime);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Lime);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Melon);
        shoppingCart.add(Item.Melon);
        BillCalculator billCalculator = new BillCalculator(shoppingCart, itemPrice, offerManager);
        int bill = billCalculator.getBill();
        int expectedPrice =
                itemPrice.getPrice(Item.Apple.name())
                        + itemPrice.getPrice(Item.Banana.name())
                        + (5 * itemPrice.getPrice(Item.Melon.name()))
                        + (2 * itemPrice.getPrice(Item.Lime.name()));
        assertThat(expectedPrice).isEqualTo(bill);
    }
}
