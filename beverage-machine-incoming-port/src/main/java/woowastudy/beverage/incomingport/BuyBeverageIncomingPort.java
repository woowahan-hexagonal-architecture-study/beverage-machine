package woowastudy.beverage.incomingport;

import woowastudy.beverage.domain.entity.BeverageBill;

public interface BuyBeverageIncomingPort {
    BeverageBill buyBeverage(BuyBeverageCommand command);
}
