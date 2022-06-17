package woowastudy.beverage.domain.entity;

import woowastudy.beverage.domain.vo.BeverageStock;
import woowastudy.beverage.domain.vo.Money;

import java.time.LocalDateTime;

public class Beverage implements NumberIdentifiableEntity<Integer> {

    private int id;

    private Money price;

    private String name; // TODO 음료 이름 비즈니스 규칙 검증 할 수 있는 역할 객체로 포장

    private LocalDateTime registrationDate; // TODO 필요한 필드인지 고민

    private BeverageStock stock;

    public Beverage(int id, Money price, String name, int stock) {
        this(id, price, name, BeverageStock.of(stock));
    }

    public Beverage(int id, Money price, String name, BeverageStock stock) {
        this(id, price, name, stock, LocalDateTime.now());
    }

    public Beverage(int id, Money price, String name, BeverageStock stock, LocalDateTime registrationDate) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.stock = stock;
        this.registrationDate = registrationDate;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public BeverageStock getStock() {
        return stock;
    }

    public void releaseStock(int quantity) {
        stock.release(quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beverage beverage = (Beverage) o;

        return id == beverage.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
