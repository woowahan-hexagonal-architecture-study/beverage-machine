package woowastudy.beverage.outgoingadapter;

import woowastudy.beverage.domain.entity.Beverage;
import woowastudy.beverage.outgoingport.BeverageRepository;
import woowastudy.beverage.outgoingport.BeverageStockRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BeverageInMemoryRepository extends InMemoryRepository<Beverage, Integer> implements BeverageRepository, BeverageStockRepository {
    private static BeverageInMemoryRepository instance;

    private BeverageInMemoryRepository() {
    }

    public static BeverageInMemoryRepository getInstance() {
        if (instance != null) {
            return instance;
        }

        instance = new BeverageInMemoryRepository();

        return instance;
    }

    @Override
    public Optional<Beverage> findById(int id) {
        return findByIdInMemory(id);
    }

    @Override
    public List<Beverage> findAll() {
        return findAllInMemory();
    }

    @Override
    public List<Beverage> findAllByIds(Collection<Integer> ids) {
        return findAllByIdsInMemory(ids);
    }

    @Override
    public void save(Beverage beverage) {
        saveInMemory(beverage);
    }

    // TODO ISP 위반하는거 나중에 쪼개기
    @Override
    public void release(int beverageId, int quantity) {
        Beverage persistenceBeverage = findById(beverageId).orElseThrow(() -> new IllegalArgumentException("음료 엔티티가 존재하지 않습니다"));

        persistenceBeverage.releaseStock(quantity);
    }
}
