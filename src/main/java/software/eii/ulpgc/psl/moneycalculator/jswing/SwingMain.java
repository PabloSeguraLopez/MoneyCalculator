package software.eii.ulpgc.psl.moneycalculator.jswing;

import software.eii.ulpgc.psl.moneycalculator.Controller.Command;
import software.eii.ulpgc.psl.moneycalculator.Controller.ExchangeMoneyCommand;
import software.eii.ulpgc.psl.moneycalculator.Model.Currency;
import software.eii.ulpgc.psl.moneycalculator.View.CurrencyDialog;
import software.eii.ulpgc.psl.moneycalculator.View.DateDialog;
import software.eii.ulpgc.psl.moneycalculator.View.MoneyDialog;
import software.eii.ulpgc.psl.moneycalculator.View.MoneyDisplay;
import software.eii.ulpgc.psl.moneycalculator.fixerapi.FixerCurrencyLoader;
import software.eii.ulpgc.psl.moneycalculator.fixerapi.FixerExchangeRateLoader;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwingMain extends JFrame {
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private DateDialog dateDialog;

    public static void main(String[] args) {
        SwingMain main = new SwingMain();
        List<Currency> currencies = new FixerCurrencyLoader().load();
        Command command = new ExchangeMoneyCommand(
                main.moneyDialog().define(currencies),
                main.currencyDialog().fillCurrencies(currencies),
                new FixerExchangeRateLoader(),
                main.moneyDisplay(),
                main.dateDialog());
        main.add("exchange money", command);
        main.setVisible(true);
    }


    public SwingMain() throws HeadlessException {
        this.setTitle("Money calculator");
        this.setMinimumSize(new Dimension(650,600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        addElements();
    }

    private void addElements() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.add(new JLabel("Original currency and quantity (Insert the quantity with a \".\" as decimal separator)"));
        panel.add(createMoneyDialog());
        panel.add(Box.createVerticalGlue());
        panel.add(new JLabel("Destination currency"));
        panel.add(createCurrencyDialog());
        panel.add(Box.createVerticalGlue());
        panel.add(new JLabel("Select a date for the ExchangeRate"));
        panel.add(createDateDialog());
        panel.add(Box.createVerticalGlue());
        panel.add(toolbar());
        panel.add(Box.createVerticalGlue());
        panel.add(new JLabel("Destination quantity (if its value is negative, an error occurred)"));
        panel.add(createMoneyDisplay());
        this.add(panel);
    }

    private Component createDateDialog() {
        SwingDateDialog dialog = new SwingDateDialog();
        dialog.setMaximumSize(new Dimension(200,200));
        this.dateDialog = dialog;
        return dialog;
    }

    private Component toolbar() {
        JButton button = new JButton("Calculate");
        button.addActionListener(e -> commands.get("exchange money").execute());
        return button;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay("Result");
        display.setPreferredSize(new Dimension(100,50));
        this.moneyDisplay = display;
        return display;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    private void add(String name, Command command) {
        commands.put(name, command);
    }

    private MoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    private CurrencyDialog currencyDialog() {
        return currencyDialog;
    }

    private MoneyDialog moneyDialog() {
        return moneyDialog;
    }

    private DateDialog dateDialog() {
        return dateDialog;
    }
}