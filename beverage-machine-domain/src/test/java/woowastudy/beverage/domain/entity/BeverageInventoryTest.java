package woowastudy.beverage.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import woowastudy.beverage.domain.vo.Money;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BeverageInventoryTest {

    @DisplayName("BeverageInventory 생성시 Beverage id의 기준으로 중복이 제거된다")
    @Test
    void ofAndItemsSize() {
        // given
        Beverage 웰치스 = new Beverage(1, Money.of(1000), "웰치스");
        Beverage 스프라이트 = new Beverage(2, Money.of(1200), "스프라이트");
        Beverage 코카콜라 = new Beverage(3, Money.of(1200), "코카콜라");
        Beverage 밀키스 = new Beverage(4, Money.of(200), "밀키스");

        // when
        BeverageInventory inventory = BeverageInventory.create();
        inventory.addItem(웰치스);
        inventory.addItem(웰치스);
        inventory.addItem(코카콜라);
        inventory.addItem(스프라이트);
        inventory.addItem(스프라이트);
        inventory.addItem(스프라이트);
        inventory.addItem(코카콜라);
        inventory.addItem(코카콜라);
        inventory.addItem(밀키스);
        inventory.addItem(스프라이트);
        inventory.addItem(밀키스);
        List<Beverage> inventoryItems = inventory.getItems();

        // then
        assertThat(inventoryItems).hasSize(4).containsExactlyInAnyOrder(웰치스, 스프라이트, 코카콜라, 밀키스);
    }
}
