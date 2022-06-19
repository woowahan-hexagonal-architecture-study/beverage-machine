package woowastudy.beverage.incomingport;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import woowastudy.beverage.domain.entity.Beverage;
import woowastudy.beverage.domain.vo.Money;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BeverageInventoryTest {

    @DisplayName("BeverageInventory 생성시 Beverage id의 기준으로 중복이 제거된다")
    @Test
    void ofAndItemsSize() {
        // given
        Beverage 웰치스 = new Beverage(1, Money.of(1000), "웰치스", 0);
        Beverage 스프라이트 = new Beverage(2, Money.of(1200), "스프라이트", 0);
        Beverage 코카콜라 = new Beverage(3, Money.of(1200), "코카콜라", 0);
        Beverage 밀키스 = new Beverage(4, Money.of(200), "밀키스", 0);

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
        List<BeverageInventoryItem> inventoryItems = inventory.getItems();

        // then
        assertThat(inventoryItems).hasSize(4).containsExactlyInAnyOrder(
                BeverageInventoryItem.from(웰치스),
                BeverageInventoryItem.from(스프라이트),
                BeverageInventoryItem.from(코카콜라),
                BeverageInventoryItem.from(밀키스));
    }
}
