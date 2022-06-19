package woowastudy.beverage.domain.entity;

public class BeverageOrder implements NumberIdentifiableEntity<Integer> {
    private static volatile int autoIncrementId = 1;

    private int id;
    private int beverageId;

    private Beverage beverage;
    private int quantity;

    public BeverageOrder(int beverageId, int quantity) {
        this(autoIncrementId++, beverageId, quantity);
    }

    public BeverageOrder(int id, int beverageId, int quantity) {
        this.id = id;
        this.beverageId = beverageId;
        this.quantity = quantity;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public int getBeverageId() {
        return beverageId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    // TODO setter 사용하지 않고, Beverage 엔티티 연관관계 가지도록 변경
    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }
}
