package woowastudy.beverage.domain.fixture;

import woowastudy.beverage.domain.entity.Beverage;
import woowastudy.beverage.domain.entity.BeverageOrder;
import woowastudy.beverage.domain.vo.Money;

import java.util.Arrays;
import java.util.List;

public class BeverageFixtureUtils {
    public static final Beverage 웰치스 = new Beverage(1, Money.of(1000), "웰치스", 5);
    public static final Beverage 스프라이트 = new Beverage(2, Money.of(1200), "스프라이트", 10);
    public static final Beverage 코카콜라 = new Beverage(3, Money.of(1200), "코카콜라", 5);
    public static final Beverage 밀키스 = new Beverage(4, Money.of(900), "밀키스", 10);


    public static List<BeverageOrder> createBeverageOrdersFixtures() {
        BeverageOrder 웰치스주문 = new BeverageOrder(웰치스.getId(),4);
        웰치스주문.setBeverage(웰치스);
        BeverageOrder 스프라이트주문 = new BeverageOrder(스프라이트.getId(),2);
        스프라이트주문.setBeverage(스프라이트);
        BeverageOrder 코카콜라주문 = new BeverageOrder(코카콜라.getId(),3);
        코카콜라주문.setBeverage(코카콜라);
        BeverageOrder 밀키스주문 = new BeverageOrder(밀키스.getId(), 2);
        밀키스주문.setBeverage(밀키스);

        return Arrays.asList(
                웰치스주문,
                스프라이트주문,
                코카콜라주문,
                밀키스주문
        );
    }
    public static List<Beverage> createPurchasedBeverageFixtures() {
        return Arrays.asList(
                 코카콜라,
                 웰치스,
                 웰치스,
                 스프라이트,
                 웰치스,
                 웰치스,
                 스프라이트,
                 코카콜라,
                 코카콜라,
                 밀키스,
                 밀키스
        );
    }
}
