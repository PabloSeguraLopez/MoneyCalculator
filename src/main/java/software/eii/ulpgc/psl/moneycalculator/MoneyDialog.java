package software.eii.ulpgc.psl.moneycalculator;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog fillCurrencies(List<Currency> currencies);
    Money get();
}
