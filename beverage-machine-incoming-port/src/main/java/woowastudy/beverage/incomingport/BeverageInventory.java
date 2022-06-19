package woowastudy.beverage.incomingport;

import woowastudy.beverage.domain.entity.Beverage;

import java.util.*;

public class BeverageInventory {

    private Map<Integer, BeverageInventoryItem> items = new HashMap<>();

    private BeverageInventory() {}

    public static BeverageInventory create() {
        return new BeverageInventory();
    }

    public void addItem(Beverage beverage) {
        BeverageInventoryItem item = BeverageInventoryItem.from(beverage);
        if(hasItem(item.getId())) {
            return;
        }

        items.put(item.getId(), item);
    }

    public List<BeverageInventoryItem> getItems() {
        List<BeverageInventoryItem> itemList = new ArrayList<>(items.values());
        itemList.sort(Comparator.comparingInt(BeverageInventoryItem::getId));

        return itemList;
    }

    public BeverageInventoryItem getItem(int itemId) {
        if(!hasItem(itemId)) {
            throw new IllegalArgumentException("인벤토리에 item이 존재하지 않습니다");
        }

        return items.get(itemId);
    }

    public boolean hasItem(int itemId) {
        return items.containsKey(itemId);
    }
}
