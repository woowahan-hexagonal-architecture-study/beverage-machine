package woowastudy.beverage.domain.vo;

public class Money implements Comparable<Money> {
    private static final int ZERO_VALUE = 0;
    public static final Money ZERO = Money.of(ZERO_VALUE);
    private int value;

    private Money(int value) {
        this.value = value;
    }

    public static Money of(int value) {
        return new Money(value);
    }

    public int get() {
        return value;
    }

    public Money plus(Money money) {
        return Money.of(this.get() + money.get());
    }

    public Money minus(Money money) {
        return Money.of(this.get() - money.get());
    }

    public boolean isZero() {
        return this.equals(ZERO);
    }

    public boolean isNegative() {
        return value < ZERO_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;

        return value == money.value;
    }

    @Override
    public int compareTo(Money o) {
        return this.value - o.value;
    }
}
