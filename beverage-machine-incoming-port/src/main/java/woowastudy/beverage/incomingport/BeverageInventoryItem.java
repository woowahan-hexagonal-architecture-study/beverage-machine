package woowastudy.beverage.incomingport;

import woowastudy.beverage.domain.entity.Beverage;
import woowastudy.beverage.domain.vo.BeverageStock;
import woowastudy.beverage.domain.vo.Money;

public class BeverageInventoryItem implements Comparable<BeverageInventoryItem> {
    private static final int DECREASE_STOCK_VALUE = 1;
    private int id;
    private String name;
    private Money price;
    private BeverageStock stock;

    public BeverageInventoryItem(int id, String name, Money price, BeverageStock stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public static BeverageInventoryItem from(Beverage beverage) {
        return new BeverageInventoryItem(
                beverage.getId(),
                beverage.getName(),
                beverage.getPrice(),
                beverage.getStock().copy());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public BeverageStock getStock() {
        return stock;
    }

    public void decreaseStock() {
        stock.release(DECREASE_STOCK_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeverageInventoryItem that = (BeverageInventoryItem) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(BeverageInventoryItem o) {
        return this.id - o.id;
    }
}
