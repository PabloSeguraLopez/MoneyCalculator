package software.eii.ulpgc.psl.moneycalculator.jswing;

import software.eii.ulpgc.psl.moneycalculator.Money;
import software.eii.ulpgc.psl.moneycalculator.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void show(Money money) {
        this.setText(money.toString());
    }
}
