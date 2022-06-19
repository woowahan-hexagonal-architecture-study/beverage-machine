package woowastudy.beverage.incomingadapter;

import woowastudy.beverage.domain.entity.BeverageBill;
import woowastudy.beverage.domain.vo.PurchasedBeverage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BeverageBillText {
    private static final String BILL_TOP_DIVIDER = IntStream.range(0, 30).mapToObj(ignore -> "-").collect(Collectors.joining());
    private static final String GREETINGS_TITLE = "구매해주셔서 감사합니다. ";
    private static final String INPUT_TOTAL_AMOUNT_TITLE = "총 투입 금액: ";
    private static final String TOTAL_AMOUNT_TITLE = "총 구매 금액: ";
    private static final String CHANGE_AMOUNT_TITLE = "거스름돈 금액: ";
    private static final String PURCHASED_BEVERAGE_LIST_TITLE = "구매한 음료 목록: ";
    private static final String BEVERAGE_LIST_BULLET_SYMBOL = "- ";
    private static final String NEXT_LINE = "\n";
    private static final String PRICE_UNIT = "원";
    private static final String BEVERAGE_QUANTITY_UNIT = "개";

    public static String text(BeverageBill bill) {
        StringBuilder sb = new StringBuilder();
        sb.append(GREETINGS_TITLE).append(NEXT_LINE)
                .append(BILL_TOP_DIVIDER).append(NEXT_LINE)
                .append(INPUT_TOTAL_AMOUNT_TITLE)
                .append(bill.calculateTotalAmount().get()).append(PRICE_UNIT).append(NEXT_LINE)
                .append(TOTAL_AMOUNT_TITLE)
                .append(bill.calculatePurchasedTotalAmount().get()).append(PRICE_UNIT).append(NEXT_LINE)
                .append(CHANGE_AMOUNT_TITLE)
                .append(bill.calculateChangeAmount().get()).append(PRICE_UNIT).append(NEXT_LINE)
                .append(PURCHASED_BEVERAGE_LIST_TITLE).append(NEXT_LINE);

        List<PurchasedBeverage> purchasedBeverages = bill.getPurchasedBeverageQuantities().get();
        for (PurchasedBeverage purchasedBeverage : purchasedBeverages) {
            sb.append(BEVERAGE_LIST_BULLET_SYMBOL)
                    .append(purchasedBeverage.getBeverage().getName())
                    .append(" ")
                    .append(purchasedBeverage.getQuantity()).append(BEVERAGE_QUANTITY_UNIT)
                    .append(NEXT_LINE);
        }

        return sb.toString();
    }
}
