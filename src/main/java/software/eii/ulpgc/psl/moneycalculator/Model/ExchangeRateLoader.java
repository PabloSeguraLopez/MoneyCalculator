package software.eii.ulpgc.psl.moneycalculator.Model;

import software.eii.ulpgc.psl.moneycalculator.Model.Currency;
import software.eii.ulpgc.psl.moneycalculator.Model.ExchangeRate;

import java.time.LocalDate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to, LocalDate date);
}
