package com.dc.shopingbasket.billing;

import com.dc.shopingbasket.cart.ShoppingCart;
import com.dc.shopingbasket.offer.ItemOfferManager;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BillCalculator {
    private final ShoppingCart shoppingCart;
    private final ItemPrice itemPrice;
    private final ItemOfferManager offerManager;

    public BillCalculator(ShoppingCart shoppingCart, ItemPrice itemPrice, ItemOfferManager offerManager) {
        this.shoppingCart = shoppingCart;
        this.itemPrice = itemPrice;
        this.offerManager = offerManager;
    }

    public int getBill(){
        Map<String, Integer> quantityByItem = new HashMap<>();
        shoppingCart.showCart()
                .forEach(
                        item -> addToMap(item, quantityByItem)
                );

        int totalBill = shoppingCart.showCart().stream()
                .map(itemPrice::getPrice)
                .reduce(0, Integer::sum);
        int discount = offerManager.applyOffer(quantityByItem, itemPrice);
        return totalBill - discount;
    }

    private Map<String, Integer> addToMap(String item, Map<String, Integer> quantityByItem) {
        int quantity = quantityByItem.getOrDefault(item, 0);
        quantityByItem.put(item, quantity + 1);
        return quantityByItem;
    }
}
