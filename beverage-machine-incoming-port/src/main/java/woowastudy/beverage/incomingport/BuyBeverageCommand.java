package woowastudy.beverage.incomingport;

import woowastudy.beverage.domain.entity.BeverageOrder;
import woowastudy.beverage.domain.vo.BeverageMachineMoneyUnits;
import woowastudy.beverage.domain.vo.Money;

import java.util.List;

public class BuyBeverageCommand {
    private Money inputTotalAmount;
    private Money totalAmount = Money.ZERO;

    private BeverageSelectionOrders beverageSelectionOrders = new BeverageSelectionOrders();

    private BeverageInventory beverageInventory;

    public BuyBeverageCommand(BeverageInventory beverageInventory) {
        this.beverageInventory = beverageInventory;
    }

    public void addAmount(int amount) throws IllegalArgumentException {
        Money amountMoney = Money.of(amount);
        if(isInvalidAmount(amountMoney)) {
            throw new IllegalArgumentException("가능한 금액 단위가 아닙니다");
        }

        totalAmount = totalAmount.plus(amountMoney);
    }

    public void selectBeverageId(int selectedBeverageId) {
        if (inputTotalAmount == null) {
            inputTotalAmount = Money.of(totalAmount.get());
        }

        if(isNotExistBeverageIdInInventory(selectedBeverageId)) {
            throw new IllegalArgumentException("현재 존재하지 않는 음료번호입니다");
        }

        BeverageInventoryItem selectedBeverageItem = beverageInventory.getItem(selectedBeverageId);

        if(isNotSufficientTotalAmount(selectedBeverageItem)) {
            throw new IllegalArgumentException("금액이 부족합니다");
        }

        selectedBeverageItem.decreaseStock();
        totalAmount = totalAmount.minus(selectedBeverageItem.getPrice());
        beverageSelectionOrders.order(selectedBeverageItem);
    }

    public boolean isNotSufficientTotalAmount(BeverageInventoryItem selectedBeverage) {
        return totalAmount.minus(selectedBeverage.getPrice()).isNegative();
    }

    private boolean isNotExistBeverageIdInInventory(int beverageId) {
        return !beverageInventory.hasItem(beverageId);
    }

    private boolean isInvalidAmount(Money amountMoney) {
        return !BeverageMachineMoneyUnits.isAvailableUnit(amountMoney);
    }

    public void validEmptyTotalAmount() {
        if(isEmptyTotalAmount()) {
            throw new IllegalArgumentException("금액이 입력되지 않았습니다");
        }
    }

    public boolean isEmptyTotalAmount() {
        return totalAmount.isZero();
    }


    public Money getInputTotalAmount() {
        return inputTotalAmount;
    }
    public Money getTotalAmount() {
        return totalAmount;
    }

    public BeverageInventory getBeverageInventory() {
        return beverageInventory;
    }

    public List<BeverageOrder> getBeverageOrders() {
        return beverageSelectionOrders.toEntities();
    }
}
