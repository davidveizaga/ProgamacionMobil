package model;

import java.util.Date;

public class ExchangeRate {

    private final Number rate;
    private final Currency fromCurrency;
    private final Currency toCurrency;
    private final Date date;

    public ExchangeRate(Number rate, Currency fromCurrency, Currency toCurrency, Date date) {
        this.rate = rate;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.date = date;
    }

    public Number getRate() {
        return rate;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public Date getDate() {
        return date;
    }
}
