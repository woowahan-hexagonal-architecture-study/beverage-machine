package woowastudy.beverage.domain.vo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BeverageMachineMoneyUnits {
    private static final List<Money> monies;

    // TODO 외부 구성 파일로 주입될 수 있도록 구현 (시간이 남는다면..?)
    static {
        monies = Arrays.asList(
                Money.of(100),
                Money.of(500),
                Money.of(1000),
                Money.of(5000),
                Money.of(10000)
        );
    }

    public static boolean isAvailableUnit(Money money) {
        return monies.stream().anyMatch(money::equals);
    }

    public static List<Money> getAvailableUnits() {
        return monies;
    }

    public static Money getMinimumAvailableUnit() {
        return getAvailableUnits().stream().min(Comparator.naturalOrder()).orElseThrow(() -> new IllegalStateException("금액 단위가 정상적으로 설정되지 않았습니다."));
    }

    public static Money getMaximumAvailableUnit() {
        return getAvailableUnits().stream().max(Comparator.naturalOrder()).orElseThrow(() -> new IllegalArgumentException("금액 단위가 정상적으로 설정되지 않았습니다."));
    }
}
