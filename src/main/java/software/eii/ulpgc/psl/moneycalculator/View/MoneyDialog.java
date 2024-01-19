package software.eii.ulpgc.psl.moneycalculator.View;

import software.eii.ulpgc.psl.moneycalculator.Model.Currency;
import software.eii.ulpgc.psl.moneycalculator.Model.Money;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);
    Money get();
}
