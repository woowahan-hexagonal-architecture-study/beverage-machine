package woowastudy.beverage.domain.vo;

import woowastudy.beverage.domain.entity.BeverageOrder;

import java.util.List;
import java.util.stream.Collectors;

public class PurchasedBeverages {
    private List<PurchasedBeverage> purchasedBeverageQuantities;

    public PurchasedBeverages(List<BeverageOrder> orders) {
        this.purchasedBeverageQuantities = associateBeverages(orders);
    }

    public List<PurchasedBeverage> get() {
        return purchasedBeverageQuantities;
    }

    public Money calculateTotalAmount() {
        Money sum = Money.ZERO;

        for (PurchasedBeverage purchasedBeverageQuantity : purchasedBeverageQuantities) {
            sum = sum.plus(purchasedBeverageQuantity.calculateTotalAmount());
        }

        return sum;
    }

    private List<PurchasedBeverage> associateBeverages(List<BeverageOrder> orders) {
        return orders.stream()
                .map(order -> new PurchasedBeverage(order.getBeverage(), order.getQuantity()))
                .sorted()
                .collect(Collectors.toList());
    }
}
