package view.ui.swing;

import command.ActionListenerFactory;
import view.ui.CurrencyDialog;
import view.ui.DateDialog;
import view.ui.MoneyDialog;
import view.ui.MoneyViewer;

import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {

    private final ActionListenerFactory factory;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private MoneyViewer moneyViewer;
    private DateDialog dateDialog;

    public ApplicationFrame(ActionListenerFactory actionListenerFactory) {
        super("Money calculator");
        this.factory = actionListenerFactory;
        this.setSize(900, 110);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createMoneyExchangePanel(), BorderLayout.NORTH);
        this.add(createToolbar(), BorderLayout.SOUTH);
    }

    private JPanel createMoneyExchangePanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(" Converting from: "));
        panel.add(createMoneyDialogPanel());
        panel.add(new JLabel(" to: "));
        panel.add(createCurrencyDialogPanel());
        panel.add(new JLabel(" at data: "));
        panel.add(createDateDialogPanel());
        panel.add(new JLabel(" = "));
        panel.add(createMoneyViewerPanel());
        return panel;
    }

    private JPanel createMoneyDialogPanel() {
        MoneyDialogPanel panel = new MoneyDialogPanel();
        moneyDialog = panel;
        panel.show();
        return panel;
    }

    private JPanel createCurrencyDialogPanel() {
        CurrencyDialogPanel panel = new CurrencyDialogPanel();
        currencyDialog = panel;
        panel.show();
        return panel;
    }

    private JPanel createMoneyViewerPanel() {
        MoneyViewerPanel panel = new MoneyViewerPanel();
        moneyViewer = panel;
        panel.show();
        return panel;
    }

    private JPanel createDateDialogPanel() {
        DateDialogPanel panel = new DateDialogPanel();
        dateDialog = panel;
        panel.show();
        return panel;
    }

    private JPanel createToolbar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(new JLabel(" Not available to convert between all currencies," +
                " but yes the conversion of the most popular (Try USD to EUR) "));
        panel.add(createCalculateButton());
        panel.add(createExitButton());
        return panel;
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(factory.getAction("calculate"));
        return button;
    }

    private JButton createExitButton() {
        JButton button = new JButton("Exit");
        button.addActionListener(factory.getAction("exit"));
        return button;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public MoneyViewer getMoneyViewer() {
        return moneyViewer;
    }

    public DateDialog getDateDialog() {
        return dateDialog;
    }

}
