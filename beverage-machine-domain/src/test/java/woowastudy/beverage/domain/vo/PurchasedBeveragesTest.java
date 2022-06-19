package woowastudy.beverage.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import woowastudy.beverage.domain.fixture.BeverageFixtureUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class PurchasedBeveragesTest {

    @DisplayName("구매한 음료 목록은 음료 id로 순정렬되고, 수량이 집계된다")
    @Test
    void create(){
        // when
        PurchasedBeverages purchasedBeverages = new PurchasedBeverages(BeverageFixtureUtils.createBeverageOrdersFixtures());

        // then
        List<Integer> purchasedBeverageIds = purchasedBeverages.get().stream().map(p -> p.getBeverage().getId()).collect(Collectors.toList());
        List<Integer> purchasedBeverageQuantities = purchasedBeverages.get().stream().map(PurchasedBeverage::getQuantity).collect(Collectors.toList());

        // 구매 음료 id로 정렬
        assertThat(purchasedBeverageIds)
                .hasSize(4)
                .containsExactly(1, 2, 3, 4);

        // 구매 음료 수량 집계 순서
        assertThat(purchasedBeverageQuantities)
                .hasSize(4)
                .containsExactly(4, 2, 3, 2);
    }

    @DisplayName("구매한 음료 목록의 총 금액은 각 음료 가격과 구매수량을 곱한 값을 모두 더한 값이다")
    @Test
    void calculateTotalAmount() {
        PurchasedBeverages purchasedBeverages = new PurchasedBeverages(BeverageFixtureUtils.createBeverageOrdersFixtures());

        // 4000 + 2400 + 3600 + 1800
        Money totalAmount = purchasedBeverages.calculateTotalAmount();

        assertThat(totalAmount).isEqualTo(Money.of(11800));
    }
}
