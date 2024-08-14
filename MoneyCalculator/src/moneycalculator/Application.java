package moneycalculator;

import command.ActionListenerFactory;
import command.CalculateCommand;
import command.Command;
import command.CommandDictionary;
import controller.ConsoleChangeRateController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.persistence.ChangeRateLoader;
import view.persistence.CurrencySetLoader;
import view.persistence.FileCurrencySetLoader;
import view.persistence.InternetChangeRateLoader;
import view.ui.console.ConsoleCurrencyDialog;
import view.ui.console.ConsoleMoneyDialog;
import view.ui.console.ConsoleMoneyViewer;
import view.ui.CurrencyDialog;
import view.ui.MoneyDialog;
import view.ui.MoneyViewer;
import view.ui.swing.ApplicationFrame;

public class Application {

    public static void main(String[] args) {
        runAppUnderSwing(args[0]);
    }

    private static void runAppUnderConsole(String file) {
        CurrencySetLoader currencySetLoader = new FileCurrencySetLoader(file);
        ChangeRateLoader changeRateLoader = new InternetChangeRateLoader();
        MoneyDialog moneyDialog = new ConsoleMoneyDialog();
        MoneyViewer moneyViewer = new ConsoleMoneyViewer();
        CurrencyDialog currencyDialog = new ConsoleCurrencyDialog();

        ConsoleChangeRateController controller = new ConsoleChangeRateController(currencySetLoader, changeRateLoader,
                moneyDialog, moneyViewer, currencyDialog);
        controller.execute();
    }

    private static void runAppUnderSwing(String file) {
        final CommandDictionary commandDictionary = new CommandDictionary();
        CurrencySetLoader currencySetLoader = new FileCurrencySetLoader(file);
        ChangeRateLoader changeRateLoader = new InternetChangeRateLoader();

        currencySetLoader.load();;
        ActionListenerFactory factory = new ActionListenerFactory() {

            @Override
            public ActionListener getAction(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        commandDictionary.get(action).execute();
                    }
                };
            }
        };

        final ApplicationFrame frame = new ApplicationFrame(factory);

        commandDictionary.register("calculate", new CalculateCommand(
                frame.getMoneyDialog(),
                frame.getCurrencyDialog(),
                frame.getDateDialog(),
                frame.getMoneyViewer(),
                changeRateLoader));
        commandDictionary.register("exit", new Command() {

            @Override
            public void execute() {
                frame.dispose();
            }
        });
    }
}
