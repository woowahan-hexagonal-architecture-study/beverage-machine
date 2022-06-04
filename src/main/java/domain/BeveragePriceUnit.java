package domain;

public class BeveragePriceUnit {
    private int priceUnit;

    private BeveragePriceUnit(int priceUnit) {
        this.priceUnit = priceUnit;
    }

    public BeveragePriceUnit of(int priceUnit) {
        return new BeveragePriceUnit(priceUnit);
    }
}
