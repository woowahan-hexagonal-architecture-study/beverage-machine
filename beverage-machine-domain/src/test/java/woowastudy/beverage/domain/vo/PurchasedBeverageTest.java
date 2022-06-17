package woowastudy.beverage.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import woowastudy.beverage.domain.entity.Beverage;

import static org.assertj.core.api.Assertions.assertThat;

class PurchasedBeverageTest {

    @DisplayName("구매한 음료의 총 금액은 음료 가격과 구매 수량을 곱한 값이다")
    @ParameterizedTest
    @CsvSource(value = {
            "1000, 5, 5000",
            "500, 5, 2500",
            "999, 10, 9990"
    })
    void calculateTotalAmount(int price, int quantity, int expected) {
        Beverage beverage = new Beverage(1, Money.of(price), "", 0);
        PurchasedBeverage purchasedBeverage = new PurchasedBeverage(beverage, quantity);

        Money purchasedBeverageTotalAmount = purchasedBeverage.calculateTotalAmount();

        assertThat(purchasedBeverageTotalAmount).isEqualTo(Money.of(expected));
    }
}
