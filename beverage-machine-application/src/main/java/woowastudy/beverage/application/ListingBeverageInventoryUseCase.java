package woowastudy.beverage.application;

import woowastudy.beverage.domain.entity.Beverage;
import woowastudy.beverage.incomingport.BeverageInventory;
import woowastudy.beverage.incomingport.ListingBeverageInventoryIncomingPort;
import woowastudy.beverage.outgoingport.BeverageRepository;

import java.util.List;

public class ListingBeverageInventoryUseCase implements ListingBeverageInventoryIncomingPort {
    private final BeverageRepository beverageRepository;

    public ListingBeverageInventoryUseCase(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    @Override
    public BeverageInventory getBeverageInventory() {
        return createBeverageInventory();
    }

    private BeverageInventory createBeverageInventory() {
        BeverageInventory inventory = BeverageInventory.create();

        List<Beverage> beverages = beverageRepository.findAll();
        beverages.forEach(inventory::addItem);

        return inventory;
    }
}
