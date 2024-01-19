package software.eii.ulpgc.psl.moneycalculator.Model;

import software.eii.ulpgc.psl.moneycalculator.Model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
