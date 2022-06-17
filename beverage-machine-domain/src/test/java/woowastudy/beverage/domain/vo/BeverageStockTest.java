package woowastudy.beverage.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BeverageStockTest {

    @DisplayName("재고 입고")
    @Test
    void restock() {
        BeverageStock stock = BeverageStock.of(0);

        stock.restock(10);
        assertThat(stock.get()).isEqualTo(10);

        stock.restock(10);
        assertThat(stock.get()).isEqualTo(20);
    }

    @DisplayName("재고 입고시 음수 수량으로 입고하면 예외 발생")
    @Test
    void negativeValueRestockException() {
        BeverageStock stock = BeverageStock.of(0);

        assertThrows(IllegalArgumentException.class, () -> stock.restock(-10));
    }

    @DisplayName("재고 출고")
    @Test
    void release() {
        BeverageStock stock = BeverageStock.of(100);

        stock.release(10);
        assertThat(stock.get()).isEqualTo(90);

        stock.release(10);
        assertThat(stock.get()).isEqualTo(80);
    }

    @DisplayName("재고 출고시 현재 재고 수량보다 더 많은 수량을 출고하려고 할 때 예외 발생")
    @Test
    void isNotReleasableException() {
        BeverageStock stock = BeverageStock.of(100);

        assertThrows(IllegalArgumentException.class, () -> stock.release(101));
    }

    @DisplayName("재고 수량이 모두 소진되면 품절 여부 반환")
    @Test
    void soldOut() {
        BeverageStock stock = BeverageStock.of(100);

        assertThat(stock.isSoldOut()).isFalse();
        stock.release(100);
        assertThat(stock.isSoldOut()).isTrue();
    }

    @DisplayName("재고 생성시 입고할 수량을 음수로 설정할 시 예외 발생")
    @Test
    void of() {
        assertThrows(IllegalArgumentException.class, () -> BeverageStock.of(-100));
        assertDoesNotThrow(() -> BeverageStock.of(0));
        assertDoesNotThrow(() -> BeverageStock.of(100));
    }
}
