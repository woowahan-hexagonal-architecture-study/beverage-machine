package woowastudy.beverage.incomingadapter;

import woowastudy.beverage.incomingport.BuyBeverageCommand;
import woowastudy.beverage.incomingport.BuyBeverageIncomingPort;
import woowastudy.beverage.incomingport.ListingBeverageInventoryIncomingPort;

import java.util.Scanner;

public class BeverageMachineCLIController {
    private final BuyBeverageIncomingPort buyBeverageIncomingPort;
    private final ListingBeverageInventoryIncomingPort listingBeverageInventoryIncomingPort;

    private static final Scanner SCANNER = new Scanner(System.in);

    private final BuyBeverageCommand buyBeverageCommand;

    public BeverageMachineCLIController(BuyBeverageIncomingPort buyBeverageIncomingPort, ListingBeverageInventoryIncomingPort listingBeverageInventoryIncomingPort) {
        this.buyBeverageIncomingPort = buyBeverageIncomingPort;
        this.listingBeverageInventoryIncomingPort = listingBeverageInventoryIncomingPort;
        this.buyBeverageCommand = new BuyBeverageCommand(listingBeverageInventoryIncomingPort.getBeverageInventory());
    }

    public void startBuying() {
        enterPrices();
        selectBeverage();

//        System.out.println("2. 원하는 음료를 골라주세요"); // TODO 음료id로 고를지 이름으로 고를지..
//        String name = SCANNER.next();
//
//        System.out.println("3. 고른 음료의 재고를 확인해주세요"); // TODO 영속화된 재고 수량 return
//        // int stock = SCANNER.nextInt();
//
//        System.out.println("-------------주문서------------");
//        System.out.println(amount + " "+ name );
//
        buyBeverageIncomingPort.buyBeverage(buyBeverageCommand);
    }

    private void enterPrices() {
        try {
            BeverageMachineInputCommand.displayEnterPriceCommand();
            BeverageMachineInputCommand.displayCurrentTotalAmount(buyBeverageCommand.getTotalAmount());
            int amountInput = SCANNER.nextInt();

            if (isExitedEnterPrice(amountInput)) {
                exitEnterPrice();
                return;
            }

            buyBeverageCommand.addAmount(amountInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        enterPrices();
    }

    private void selectBeverage() {
        try {
            BeverageMachineInputCommand.displayBeverageItemSelection(buyBeverageCommand.getBeverageInventory());
            BeverageMachineInputCommand.displayCurrentTotalAmount(buyBeverageCommand.getTotalAmount());
            int beverageIdInput = SCANNER.nextInt();

            if (isExitedBeverageSelection(beverageIdInput)) {
                return;
            }

            buyBeverageCommand.selectBeverageId(beverageIdInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        selectBeverage();
    }

    private boolean isExitedBeverageSelection(int beverageIdInput) {
        return beverageIdInput == BeverageMachineInputCommand.ENTER_BEVERAGE_SELECTION_EXIT_NUMBER;
    }

    private boolean isExitedEnterPrice(int amountInput) {
        return amountInput == BeverageMachineInputCommand.ENTER_PRICE_EXIT_NUMBER;
    }

    private void exitEnterPrice() {
        buyBeverageCommand.validEmptyTotalAmount();
    }
}
