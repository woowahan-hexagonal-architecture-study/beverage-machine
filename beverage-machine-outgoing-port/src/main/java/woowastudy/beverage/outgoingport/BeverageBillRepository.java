package woowastudy.beverage.outgoingport;

import woowastudy.beverage.domain.entity.BeverageBill;

public interface BeverageBillRepository {
    void save(BeverageBill beverageBill);
}
