package woowastudy.beverage.application;

import woowastudy.beverage.domain.entity.Beverage;
import woowastudy.beverage.domain.entity.BeverageBill;
import woowastudy.beverage.domain.entity.BeverageOrder;
import woowastudy.beverage.incomingport.BuyBeverageCommand;
import woowastudy.beverage.incomingport.BuyBeverageIncomingPort;
import woowastudy.beverage.outgoingport.BeverageBillRepository;
import woowastudy.beverage.outgoingport.BeverageRepository;
import woowastudy.beverage.outgoingport.BeverageStockRepository;

import java.util.List;

public class BuyBeverageUseCase implements BuyBeverageIncomingPort {
    private final BeverageRepository beverageRepository;
    private final BeverageStockRepository beverageStockRepository;
    private final BeverageBillRepository beverageBillRepository;

    public BuyBeverageUseCase(BeverageRepository beverageRepository, BeverageStockRepository beverageStockRepository, BeverageBillRepository beverageBillRepository) {
        this.beverageRepository = beverageRepository;
        this.beverageStockRepository = beverageStockRepository;
        this.beverageBillRepository = beverageBillRepository;
    }

    @Override
    public BeverageBill buyBeverage(BuyBeverageCommand command) {
        List<BeverageOrder> beverageOrders = command.getBeverageOrders();

        for (BeverageOrder beverageOrder : beverageOrders) {
            Beverage persistenceBeverage = beverageRepository.findById(beverageOrder.getBeverageId()).orElseThrow(IllegalArgumentException::new);
            beverageOrder.setBeverage(persistenceBeverage);
            persistenceBeverage.releaseStock(beverageOrder.getQuantity());
        }

        BeverageBill bill = new BeverageBill(beverageOrders, command.getInputTotalAmount());

        beverageBillRepository.save(bill);

        return bill;
    }
}
