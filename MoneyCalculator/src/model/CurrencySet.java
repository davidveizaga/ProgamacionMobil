package model;

import java.util.ArrayList;
import java.util.HashSet;

public class CurrencySet extends HashSet<Currency> {

    public static CurrencySet instance;

    private CurrencySet() {
        super();
    }

    public static CurrencySet getInstance() {
        if (instance == null)
            instance = new CurrencySet();
        return instance;
    }

    public Currency getCurrency(String code) {
        for (Currency currency : this)
            if (code.equals(currency.getCode()))
                return currency;
        return null;
    }

    public Currency[] search(String token) {
        ArrayList<Currency> currencies = new ArrayList();
        for (Currency currency : this) {
            if (token.equalsIgnoreCase(currency.getCode()))
                currencies.add(currency);
            if (token.equalsIgnoreCase(currency.getSymbol()))
                currencies.add(currency);
            if (currency.getName().toLowerCase().contains(token.toLowerCase()))
                currencies.add(currency);
        }
        return currencies.toArray(new Currency[0]);
    }

}
