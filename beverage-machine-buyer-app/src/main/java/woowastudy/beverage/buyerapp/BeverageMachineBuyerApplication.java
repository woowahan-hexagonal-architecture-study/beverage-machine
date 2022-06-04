package woowastudy.beverage.buyerapp;

import woowastudy.beverage.buyerconfiguration.AssembleBuyerComponents;
import woowastudy.beverage.incomingadapter.BeverageMachineCLIController;

public class BeverageMachineBuyerApplication {
    public static void main(String[] args) {
        AssembleBuyerComponents assembleBuyerComponents = AssembleBuyerComponents.assemble();
        BeverageMachineCLIController controller = assembleBuyerComponents.controller();

        controller.startBuying();
    }
}
