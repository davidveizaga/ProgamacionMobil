package view.ui.console;

import model.Currency;
import view.ui.CurrencyViewer;

public class ConsoleCurrencyViewer implements CurrencyViewer {

    private Currency currency;

    public ConsoleCurrencyViewer(Currency currency) {
        this.currency = currency;
    }

    public ConsoleCurrencyViewer() {
    }

    @Override
    public void show() {
        System.out.println(currency);
    }

    @Override
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

}
