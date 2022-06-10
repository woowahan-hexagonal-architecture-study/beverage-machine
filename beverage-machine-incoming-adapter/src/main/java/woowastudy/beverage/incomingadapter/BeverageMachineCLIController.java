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
        System.out.println("🕹 안녕하세요, 헥사고날 아키텍처 토이프로젝트 입니다.");

        System.out.println("1. 원하는 금액을 입력해주세요");
        int amount = SCANNER.nextInt();

        System.out.println("2. 원하는 음료를 골라주세요"); // TODO 음료id로 고를지 이름으로 고를지..
        String name = SCANNER.next();

        System.out.println("3. 고른 음료의 재고를 확인해주세요"); // TODO 영속화된 재고 수량 return
        // int stock = SCANNER.nextInt();

        System.out.println("-------------주문서------------");
        System.out.println(amount + " "+ name );

        buyBeverageIncomingPort.BuyBeverage(new BuyBeverageCommand(amount,name)); // TODO 입출력 모델을 커맨드로 변환해서 넘겨주세요~
    }
}
