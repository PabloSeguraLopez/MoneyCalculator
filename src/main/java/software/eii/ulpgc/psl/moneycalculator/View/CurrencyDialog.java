package software.eii.ulpgc.psl.moneycalculator.View;

import software.eii.ulpgc.psl.moneycalculator.Model.Currency;

import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog fillCurrencies(List<Currency> currencies);
    Currency get();
}
