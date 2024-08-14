package view.ui.swing;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Money;
import view.ui.MoneyViewer;

public class MoneyViewerPanel extends JPanel implements MoneyViewer {

    private Money money;
    private JLabel label;

    public MoneyViewerPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel("0");
    }

    @Override
    public void show() {
        this.add(createLabel());
    }

    private JLabel createLabel() {
        if (money != null)
            label.setText(String.valueOf(money));
        return label;
    }

    @Override
    public void setMoney(Money money) {
        this.money = money;
    }

}
