package software.eii.ulpgc.psl.moneycalculator;

public class ExchangeMoneyCommand implements Command{
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;
    private final DateDialog dateDialog;

    public ExchangeMoneyCommand(MoneyDialog moneyDialog,
                                CurrencyDialog currencyDialog,
                                ExchangeRateLoader exchangeRateLoader,
                                MoneyDisplay moneyDisplay,
                                DateDialog dateDialog) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
        this.dateDialog = dateDialog;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();

        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency, dateDialog.get());
        Money result = new Money(currency, money.quantity()*exchangeRate.rate());

        moneyDisplay.show(result);
    }
}
