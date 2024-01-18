package software.eii.ulpgc.psl.moneycalculator.jswing;

import software.eii.ulpgc.psl.moneycalculator.*;
import software.eii.ulpgc.psl.moneycalculator.fixerapi.FixerCurrencyLoader;
import software.eii.ulpgc.psl.moneycalculator.fixerapi.FixerExchangeRateLoader;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
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
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(createMoneyDialog());
        this.add(createCurrencyDialog());
        this.add(createMoneyDisplay());
        this.add(createDateDialog());
        this.add(toolbar());
    }

    private Component createDateDialog() {
        SwingDateDialog dialog = new SwingDateDialog();
        this.dateDialog = dialog;
        return dialog;
    }

    private Component toolbar() {
        JButton button = new JButton("calculate");
        button.addActionListener(e -> commands.get("exchange money").execute());
        return button;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
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