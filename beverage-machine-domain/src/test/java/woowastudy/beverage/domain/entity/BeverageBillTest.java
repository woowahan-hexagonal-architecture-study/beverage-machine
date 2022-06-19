package woowastudy.beverage.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import woowastudy.beverage.domain.fixture.BeverageFixtureUtils;
import woowastudy.beverage.domain.vo.Money;

import static org.assertj.core.api.Assertions.assertThat;

class BeverageBillTest {

    @DisplayName("구매 청구서의 거스름돈은 입력한 금액에서 구매 총합금액을 뺀 값이다")
    @Test
    void calculateChangeAmount() {
        BeverageBill bill = new BeverageBill(1, BeverageFixtureUtils.createBeverageOrdersFixtures(), Money.of(20000));

        assertThat(bill.calculateChangeAmount()).isEqualTo(Money.of(8200));
    }
}
