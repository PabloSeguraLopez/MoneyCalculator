package software.eii.ulpgc.psl.moneycalculator;

import java.time.LocalDate;

public record ExchangeRate(Currency from, Currency to, long rate, LocalDate date){
}
