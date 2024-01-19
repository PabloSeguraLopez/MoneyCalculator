package software.eii.ulpgc.psl.moneycalculator.jswing;

import software.eii.ulpgc.psl.moneycalculator.Model.Currency;
import software.eii.ulpgc.psl.moneycalculator.View.CurrencyDialog;
import software.eii.ulpgc.psl.moneycalculator.Model.Money;
import software.eii.ulpgc.psl.moneycalculator.View.MoneyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private JTextField amountField;
    private CurrencyDialog currencyDialog;

    public SwingMoneyDialog() {
        this.setLayout(new FlowLayout());
    }

    @Override
    public MoneyDialog define(java.util.List<Currency> currencies) {
        add(createAmountField());
        add(createCurrencyDialog(currencies));
        return this;
    }

    private Component createCurrencyDialog(List<Currency> currencies) {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        dialog.fillCurrencies(currencies);
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createAmountField() {
        JTextField textField = new JTextField();
        textField.setColumns(5);
        this.amountField = textField;
        return textField;
    }

    @Override
    public Money get() {
        return new Money(currencyDialog.get(), toDouble(amountField.getText()  ));
    }

    private double toDouble(String text) {
        return Double.parseDouble(text);
    }
}
