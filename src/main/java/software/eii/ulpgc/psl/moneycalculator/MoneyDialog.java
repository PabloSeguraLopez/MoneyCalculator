package software.eii.ulpgc.psl.moneycalculator;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);
    Money get();
}
