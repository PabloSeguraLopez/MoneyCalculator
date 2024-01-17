package software.eii.ulpgc.psl.moneycalculator;

import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog fillCurrencies(List<Currency> currencies);
    Currency get();
}
