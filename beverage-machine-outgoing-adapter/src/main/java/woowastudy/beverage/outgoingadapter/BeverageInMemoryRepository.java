package woowastudy.beverage.outgoingadapter;

import woowastudy.beverage.domain.entity.Beverage;
import woowastudy.beverage.outgoingport.BeverageRepository;

import java.util.ArrayList;
import java.util.List;

public class BeverageInMemoryRepository implements BeverageRepository {
    private static BeverageInMemoryRepository instance;

    private final List<Beverage> beverages = new ArrayList<>();

    private BeverageInMemoryRepository() {}

    public static BeverageInMemoryRepository getInstance() {
        if(instance != null) {
            return instance;
        }

        instance = new BeverageInMemoryRepository();

        return instance;
    }

    @Override
    public List<Beverage> findAll() {
        return beverages;
    }

    @Override
    public void save(Beverage beverage) {
        beverages.add(beverage);
    }
}
