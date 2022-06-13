package woowastudy.beverage.domain;

import java.time.LocalDateTime;

public class Beverage {
    
    private int id;

    private int price;

    private int name;

    private LocalDateTime registrationDate;

    public Beverage(int id, int price, int name, LocalDateTime registrationDate) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.registrationDate = registrationDate;
    }

}
