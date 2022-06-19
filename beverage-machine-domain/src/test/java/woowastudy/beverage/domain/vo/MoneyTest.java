package woowastudy.beverage.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @DisplayName("더하기")
    @Test
    void plus() {
        assertThat(Money.of(2).plus(Money.of(10))).isEqualTo(Money.of(12));
        assertThat(Money.of(10).plus(Money.of(5))).isEqualTo(Money.of(15));
        assertThat(Money.of(990).plus(Money.of(-90))).isEqualTo(Money.of(900));
    }

    @DisplayName("빼기")
    @Test
    void minus() {
        assertThat(Money.of(2).minus(Money.of(10))).isEqualTo(Money.of(-8));
        assertThat(Money.of(10).minus(Money.of(5))).isEqualTo(Money.of(5));
        assertThat(Money.of(990).minus(Money.of(-90))).isEqualTo(Money.of(1080));
    }

    @DisplayName("제로")
    @Test
    void zero() {
        assertThat(Money.of(10).minus(Money.of(10))).isEqualTo(Money.ZERO);
        assertThat(Money.of(10).minus(Money.of(10)).isZero()).isTrue();
        assertThat(Money.of(10).plus(Money.of(-10))).isEqualTo(Money.ZERO);
        assertThat(Money.of(10).plus(Money.of(-10)).isZero()).isTrue();
    }

    @DisplayName("음수")
    @Test
    void negative() {
        assertThat(Money.of(-1).isNegative()).isTrue();
        assertThat(Money.of(-99999).isNegative()).isTrue();

        assertThat(Money.of(0).isNegative()).isFalse();
        assertThat(Money.of(1).isNegative()).isFalse();
        assertThat(Money.of(99999).isNegative()).isFalse();
    }

    @DisplayName("값 대소 비교")
    @Test
    void valueComparison() {
        assertThat(Money.of(2)).isEqualTo(Money.of(2));

        assertThat(Money.of(2)).isLessThan(Money.of(3));
        assertThat(Money.of(3)).isLessThanOrEqualTo(Money.of(3));

        assertThat(Money.of(3)).isGreaterThan(Money.of(2));
        assertThat(Money.of(3)).isGreaterThanOrEqualTo(Money.of(3));
    }

    @DisplayName("기본 정렬 비교")
    @Test
    void valueSortedComparison() {
        List<Money> monies = Arrays.asList(
                Money.of(100000),
                Money.of(1),
                Money.of(999),
                Money.of(3),
                Money.of(10),
                Money.of(7),
                Money.of(2)
        );

        Collections.sort(monies);

        assertThat(monies).containsExactly(
                Money.of(1),
                Money.of(2),
                Money.of(3),
                Money.of(7),
                Money.of(10),
                Money.of(999),
                Money.of(100000)
        );
    }
}
