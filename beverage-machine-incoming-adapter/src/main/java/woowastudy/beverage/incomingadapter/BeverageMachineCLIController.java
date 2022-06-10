package woowastudy.beverage.incomingadapter;

import woowastudy.beverage.incomingport.BuyBeverageCommand;
import woowastudy.beverage.incomingport.BuyBeverageIncomingPort;

import java.util.Scanner;

public class BeverageMachineCLIController {
    private final BuyBeverageIncomingPort buyBeverageIncomingPort;
    private static final Scanner SCANNER = new Scanner(System.in);

    public BeverageMachineCLIController(BuyBeverageIncomingPort buyBeverageIncomingPort) {
        this.buyBeverageIncomingPort = buyBeverageIncomingPort;
    }

    public void startBuying() {
        // TODO 입출력 예시에 맞게 입출력을 구현

        buyBeverageIncomingPort.BuyBeverage(new BuyBeverageCommand()); // TODO 입출력 모델을 커맨드로 변환해서 넘겨주세요~
    }
}
