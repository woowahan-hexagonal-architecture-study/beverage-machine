package woowastudy.beverage.domain.vo;

public class BeverageStock {
    private static final int MINIMUM_VALUE = 0;
    private int value;

    private BeverageStock(int value) {
        this.value = value;
    }

    public static BeverageStock of(int value) {
        BeverageStock beverageStock = new BeverageStock(0);

        beverageStock.restock(value);

        return beverageStock;
    }

    public void restock(int restockValue) {
        if(isNegativeRestock(restockValue)) {
            throw new IllegalArgumentException("잘못된 입고 수량입니다");
        }

        value += restockValue;
    }

    public void release(int releaseValue) {
        if(isNotReleasable(releaseValue)) {
            throw new IllegalArgumentException("재고가 부족합니다");
        }
        value -= releaseValue;
    }

    private boolean isNegativeRestock(int restockValue) {
        return restockValue < MINIMUM_VALUE;
    }

    private boolean isNotReleasable(int releaseValue) {
        return value - releaseValue < MINIMUM_VALUE;
    }

    public boolean isSoldOut() {
        return value <= MINIMUM_VALUE;
    }

    public int get() {
        return value;
    }
}
