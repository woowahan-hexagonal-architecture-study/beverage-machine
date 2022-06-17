package woowastudy.beverage.incomingadapter;

import woowastudy.beverage.domain.vo.BeverageMachineMoneyUnits;
import woowastudy.beverage.domain.vo.Money;
import woowastudy.beverage.incomingport.BeverageInventory;
import woowastudy.beverage.incomingport.BeverageInventoryItem;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BeverageMachineInputCommand {
    public static final int ENTER_PRICE_EXIT_NUMBER = 0;
    public static final String ENTER_PRICE_COMMAND = String.format("금액을 입력해주세요(금액 입력을 종료하시려면 %d을 입력해주세요)", BeverageMachineInputCommand.ENTER_PRICE_EXIT_NUMBER);
    public static final int ENTER_BEVERAGE_SELECTION_EXIT_NUMBER = 0;
    public static final String BEVERAGE_SELECTION_COMMAND = String.format("구매하실 음료의 번호를 입력해주세요(구매를 종료하시려면 %d을 입력해주세요)", BeverageMachineInputCommand.ENTER_BEVERAGE_SELECTION_EXIT_NUMBER);
    private static final String DISPLAY_MONEY_UNIT = "원";
    private static final String DISPLAY_MONEY_UNITS_DELIMITER = ", ";
    private static final String DISPLAY_BEVERAGE_DELIMITER = ", ";

    public static void displayEnterPriceCommand() {
        System.out.print(ENTER_PRICE_COMMAND);
        System.out.print(":");
        displayEnterPriceUnitsGuide();
    }

    public static void displayCurrentTotalAmount(Money currentTotalAmount) {
        System.out.println(String.format("현재 총 금액: %d%s", currentTotalAmount.get(), DISPLAY_MONEY_UNIT));
    }

    public static void displayBeverageItemSelection(BeverageInventory inventory) {
        System.out.println(BEVERAGE_SELECTION_COMMAND);
        System.out.println(createDisplayableBeverageInventoryText(inventory));
    }

    private static void displayEnterPriceUnitsGuide() {
        System.out.println(createAvailableUnitsGuideText());
    }

    private static String createDisplayableBeverageInventoryText(BeverageInventory inventory) {
        return inventory.getItems().stream().map(BeverageMachineInputCommand::createDisplayableBeverageText).collect(Collectors.joining(DISPLAY_BEVERAGE_DELIMITER));
    }

    private static String createDisplayableBeverageText(BeverageInventoryItem item) {
        return String.format("%d] %s(%d, %d)", item.getId(), item.getName(), item.getPrice().get(), item.getStock().get());
    }

    private static String createAvailableUnitsGuideText() {
        List<Money> availableUnits = BeverageMachineMoneyUnits.getAvailableUnits();
        Collections.sort(availableUnits);

        String availableUnitsGuideText = availableUnits.stream().map(unit -> unit.get() + DISPLAY_MONEY_UNIT).collect(Collectors.joining(DISPLAY_MONEY_UNITS_DELIMITER));

        StringBuilder sb = new StringBuilder();
        sb.append(availableUnitsGuideText);
        sb.append(" ");
        sb.append("단위 입력 가능");

        return sb.toString();
    }
}
