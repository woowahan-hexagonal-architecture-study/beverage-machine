package woowastudy.beverage.domain.entity;

import java.util.*;

public class BeverageInventory {

    private Map<Integer, Beverage> items = new HashMap<>();

    private BeverageInventory() {}

    public static BeverageInventory create() {
        return new BeverageInventory();
    }

    public void addItem(Beverage beverage) {
        if(hasItem(beverage.getId())) {
            return;
        }

        items.put(beverage.getId(), beverage);
    }

    public List<Beverage> getItems() {
        List<Beverage> itemList = new ArrayList<>(items.values());
        itemList.sort(Comparator.comparingInt(Beverage::getId));

        return itemList;
    }

    public Beverage getItem(int itemId) {
        if(!hasItem(itemId)) {
            throw new IllegalArgumentException("인벤토리에 item이 존재하지 않습니다");
        }

        return items.get(itemId);
    }

    public boolean hasItem(int itemId) {
        return items.containsKey(itemId);
    }
}
