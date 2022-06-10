package woowastudy.beverage.incomingport;

import static java.util.Objects.isNull;

public class BuyBeverageCommand {
    private static final int MAX_AMOUNT = 100000;

    private int amount;

    private String name;

    public BuyBeverageCommand(int amount, String name) {
        // 입력 유효성 검증 -  각 파라미터에 대해 메소드 추출
        System.out.println("BuyBeverageCommand >> 입력 유효성 검증 시작");
        validateAmount(amount);
        validateName(name);

        this.amount = amount;
        this.name = name;

        System.out.println("BuyBeverageCommand >> 입력 유효성 검증 완료");
    }

    private void validateAmount(int amount){
        if (isNull(amount)){
            System.out.println("[alert] 최소 금액 유효성 검증 위반");
        }
        else if (amount>MAX_AMOUNT){
            System.out.println("[alert] 최대 금액 유효성 검증 위반");
        }
        else if (amount%10 != 0){
            System.out.println("[alert] 단위 금액 유효성 검증 위반");
        }
    }

    private void validateName(String name){
        if (name.length() <3){
            System.out.println("[alert] 음료명 유효성 검증 위반");
        }
    }

    @Override
    public String toString() {
        return "BuyBeverageCommand{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }
}
