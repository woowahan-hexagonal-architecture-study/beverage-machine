package woowastudy.beverage.domain.entity;

import woowastudy.beverage.domain.vo.Money;
import woowastudy.beverage.domain.vo.PurchasedBeverages;

import java.util.List;

public class BeverageBill implements NumberIdentifiableEntity<Integer> {
    private static volatile int autoIncrementId = 1;
    private int id;
    private PurchasedBeverages purchasedBeverageQuantities;
    private Money totalAmount;

    public BeverageBill(int id, List<BeverageOrder> orders, Money totalAmount) {
        this.id = id;
        this.purchasedBeverageQuantities = new PurchasedBeverages(orders);
        this.totalAmount = totalAmount;
    }

    public BeverageBill(List<BeverageOrder> orders, Money totalAmount) {
        this(autoIncrementId++, orders, totalAmount);
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Money calculateChangeAmount() {
        return totalAmount.minus(calculatePurchasedTotalAmount());
    }

    public Money calculateTotalAmount() {
        return totalAmount;
    }

    public Money calculatePurchasedTotalAmount() {
        return purchasedBeverageQuantities.calculateTotalAmount();
    }

    public PurchasedBeverages getPurchasedBeverageQuantities() {
        return purchasedBeverageQuantities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeverageBill that = (BeverageBill) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
