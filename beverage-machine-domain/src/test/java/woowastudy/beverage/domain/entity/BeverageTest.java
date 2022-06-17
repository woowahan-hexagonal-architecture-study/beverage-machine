package woowastudy.beverage.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import woowastudy.beverage.domain.vo.Money;

import static org.assertj.core.api.Assertions.assertThat;

class BeverageTest {

    @DisplayName("Beverage 도메인 객체는 id가 같으면 같은 객체다")
    @ParameterizedTest
    @ValueSource(ints = {1, 100, 1000, 10000, 9999})
    void equalsAndHashCode(int id) {
        // given, when
        Beverage beverage = new Beverage(id, Money.ZERO, "");
        Beverage beverage2 = new Beverage(id, Money.ZERO, "");

        // then
        assertThat(beverage.equals(beverage2)).isTrue();
    }
}
