package model;

public class MoneyExchanger {

    public static Money exchange(Number number, ExchangeRate rate) {
        return new Money(number.multiply(rate.getRate()), rate.getToCurrency());
    }
}
