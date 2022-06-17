package woowastudy.beverage.incomingport;

import woowastudy.beverage.domain.entity.BeverageOrder;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BeverageSelectionOrders {
    private static final int INITIALIZED_QUANTITY = 0;
    private static final int ADDITIONAL_QUANTITY_UNIT = 1;
    private Map<BeverageInventoryItem, Integer> orders = new TreeMap<>();

    public void order(BeverageInventoryItem item) {
        orders.put(item, getOrderQuantity(item) + ADDITIONAL_QUANTITY_UNIT);
    }

    public Integer getOrderQuantity(BeverageInventoryItem item) {
        return orders.getOrDefault(item, INITIALIZED_QUANTITY);
    }

    public List<BeverageOrder> toEntities() {
        return orders.entrySet()
                .stream()
                .map(entry -> new BeverageOrder(entry.getKey().getId(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
