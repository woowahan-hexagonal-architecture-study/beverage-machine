package woowastudy.beverage.domain.vo;

public class BeverageStock {
    private static final int MINIMUM_VALUE = 0;
    private int value;

    private BeverageStock(int value) {
        this.value = value;
    }

    public static BeverageStock of(int value) {
        BeverageStock beverageStock = new BeverageStock(MINIMUM_VALUE);

        beverageStock.restock(value);

        return beverageStock;
    }

    public void restock(int quantity) {
        if(isNegativeRestock(quantity)) {
            throw new IllegalArgumentException("잘못된 입고 수량입니다");
        }

        value += quantity;
    }

    private boolean isNegativeRestock(int restockValue) {
        return restockValue < MINIMUM_VALUE;
    }

    public void release(int quantity) {
        if(isNotReleasable(quantity)) {
            throw new IllegalArgumentException("재고가 부족합니다");
        }
        value -= quantity;
    }

    public boolean isSoldOut() {
        return value <= MINIMUM_VALUE;
    }

    public int get() {
        return value;
    }

    public boolean isNotReleasable(int releaseValue) {
        return value - releaseValue < MINIMUM_VALUE;
    }

    public BeverageStock copy() {
        return of(value);
    }
}
