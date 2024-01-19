package software.eii.ulpgc.psl.moneycalculator.Model;

import java.time.LocalDate;

public record ExchangeRate(Currency from, Currency to, double rate, LocalDate date){
}
