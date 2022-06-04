package woowastudy.beverage.buyerconfiguration;

import woowastudy.beverage.application.BuyBeverageUseCase;
import woowastudy.beverage.incomingadapter.BeverageMachineCLIController;
import woowastudy.beverage.incomingport.BuyBeverageIncomingPort;

public class AssembleBuyerComponents {
    private BuyBeverageIncomingPort buyBeverageIncomingPort;
    private BeverageMachineCLIController beverageMachineCLIController;

    private AssembleBuyerComponents() {
    }

    public static AssembleBuyerComponents assemble() {
        BuyBeverageIncomingPort buyBeverageIncomingPort = new BuyBeverageUseCase();
        BeverageMachineCLIController beverageMachineCLIController = new BeverageMachineCLIController(buyBeverageIncomingPort);

        AssembleBuyerComponents assembleBuyerComponents = new AssembleBuyerComponents();

        assembleBuyerComponents.buyBeverageIncomingPort = buyBeverageIncomingPort;
        assembleBuyerComponents.beverageMachineCLIController = beverageMachineCLIController;

        return assembleBuyerComponents;
    }

    public BeverageMachineCLIController controller() {
        return beverageMachineCLIController;
    }
}
