package software.eii.ulpgc.psl.moneycalculator.jswing;

import software.eii.ulpgc.psl.moneycalculator.Model.Money;
import software.eii.ulpgc.psl.moneycalculator.View.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    public SwingMoneyDisplay(String text) {
        super(text);
    }

    @Override
    public void show(Money money) {
        this.setText(money.toString());
    }
}
