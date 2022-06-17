package woowastudy.beverage.domain.vo;

import woowastudy.beverage.domain.entity.Beverage;

public class PurchasedBeverage implements Comparable<PurchasedBeverage> {
    private Beverage beverage;
    private int purchaseQuantity;

    public PurchasedBeverage(Beverage beverage, int purchaseQuantity) {
        this.beverage = beverage;
        this.purchaseQuantity = purchaseQuantity;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public int getQuantity() {
        return purchaseQuantity;
    }

    public Money calculateTotalAmount() {
        Money sum = Money.ZERO;

        for (int i = 0; i < purchaseQuantity; i++) {
            sum = sum.plus(beverage.getPrice());
        }

        return sum;
    }

    @Override
    public int compareTo(PurchasedBeverage o) {
        return this.beverage.getId() - o.beverage.getId();
    }
}
