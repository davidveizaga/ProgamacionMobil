package command;

import view.persistence.ChangeRateLoader;
import view.ui.CurrencyDialog;
import view.ui.MoneyDialog;

public class ExitCommand extends Command {
 
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ChangeRateLoader changeRate;

    public ExitCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ChangeRateLoader changeRate) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.changeRate = changeRate;
    }

    @Override
    public void execute() {

    }

}
