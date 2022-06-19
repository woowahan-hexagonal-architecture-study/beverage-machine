package woowastudy.beverage.outgoingadapter;

import woowastudy.beverage.domain.entity.BeverageBill;
import woowastudy.beverage.outgoingport.BeverageBillRepository;

public class BeverageBillInMemoryRepository extends InMemoryRepository<BeverageBill, Integer> implements BeverageBillRepository {
    private static BeverageBillInMemoryRepository instance;

    private BeverageBillInMemoryRepository() {
    }

    public static BeverageBillInMemoryRepository getInstance() {
        if (instance != null) {
            return instance;
        }

        instance = new BeverageBillInMemoryRepository();

        return instance;
    }

    @Override
    public void save(BeverageBill beverageBill) {
        saveInMemory(beverageBill);
    }
}
