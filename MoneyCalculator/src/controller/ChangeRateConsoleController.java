package controller;

import model.Currency;
import model.ExchangeRate;
import model.Money;
import model.MoneyExchanger;
import view.persistence.ChangeRateLoader;
import view.persistence.CurrencySetLoader;
import view.ui.CurrencyDialog;
import view.ui.MoneyDialog;
import view.ui.MoneyViewer;

public class ChangeRateConsoleController {

    private final CurrencySetLoader currencySetLoader;
    private final ChangeRateLoader changeRateLoader;
    private final MoneyDialog moneyDialog;
    private final MoneyViewer moneyViewer;
    private final CurrencyDialog currencyDialog;

    public ChangeRateConsoleController(CurrencySetLoader currencySetLoader, ChangeRateLoader changeRateLoader, MoneyDialog moneyDialog, MoneyViewer moneyViewer, CurrencyDialog currencyDialog) {
        this.currencySetLoader = currencySetLoader;
        this.changeRateLoader = changeRateLoader;
        this.moneyDialog = moneyDialog;
        this.moneyViewer = moneyViewer;
        this.currencyDialog = currencyDialog;
    }

    public void execute() {
        currencySetLoader.load();
        Money money = getMoney();
        ExchangeRate rate = changeRateLoader.load(money.getCurrency(), getCurrency());
        Money resultingMoney = MoneyExchanger.exchange(money.getAmount(), rate);
        moneyViewer.setMoney(resultingMoney);
        moneyViewer.show();
    }

    private Money getMoney() {
        moneyDialog.show();
        return moneyDialog.getMoney();
    }

    private Currency getCurrency() {
        currencyDialog.show();
        return currencyDialog.getCurrency();
    }

}
