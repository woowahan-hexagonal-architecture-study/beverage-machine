package woowastudy.beverage.buyerconfiguration;

import woowastudy.beverage.application.BuyBeverageUseCase;
import woowastudy.beverage.application.ListingBeverageInventoryUseCase;
import woowastudy.beverage.domain.entity.Beverage;
import woowastudy.beverage.domain.vo.Money;
import woowastudy.beverage.incomingadapter.BeverageMachineCLIController;
import woowastudy.beverage.incomingport.BuyBeverageIncomingPort;
import woowastudy.beverage.incomingport.ListingBeverageInventoryIncomingPort;
import woowastudy.beverage.outgoingadapter.BeverageBillInMemoryRepository;
import woowastudy.beverage.outgoingadapter.BeverageInMemoryRepository;
import woowastudy.beverage.outgoingport.BeverageRepository;

import java.util.Arrays;
import java.util.List;

public class AssembleBuyerComponents {
    private BeverageMachineCLIController beverageMachineCLIController;

    private AssembleBuyerComponents() {
    }

    public static AssembleBuyerComponents assemble() {
        initializeBeverages();

        BuyBeverageIncomingPort buyBeverageIncomingPort = new BuyBeverageUseCase(BeverageInMemoryRepository.getInstance(), BeverageInMemoryRepository.getInstance(), BeverageBillInMemoryRepository.getInstance());
        ListingBeverageInventoryIncomingPort listingBeverageInventoryIncomingPort = new ListingBeverageInventoryUseCase(BeverageInMemoryRepository.getInstance());

        BeverageMachineCLIController beverageMachineCLIController = new BeverageMachineCLIController(buyBeverageIncomingPort, listingBeverageInventoryIncomingPort);

        AssembleBuyerComponents assembleBuyerComponents = new AssembleBuyerComponents();

        assembleBuyerComponents.beverageMachineCLIController = beverageMachineCLIController;

        return assembleBuyerComponents;
    }

    private static void initializeBeverages() {
        // TODO 외부 구성 파일로 주입될 수 있도록 구현
        List<Beverage> initializingBeverages = Arrays.asList(
                new Beverage(1, Money.of(1000), "웰치스", 5),
                new Beverage(2, Money.of(1200), "스프라이트", 10),
                new Beverage(3, Money.of(1200), "코카콜라", 5),
                new Beverage(4, Money.of(900), "밀키스", 10)
        );

        BeverageRepository beverageRepository = BeverageInMemoryRepository.getInstance();

        initializingBeverages.forEach(beverageRepository::save);
    }

    public BeverageMachineCLIController controller() {
        return beverageMachineCLIController;
    }
}
