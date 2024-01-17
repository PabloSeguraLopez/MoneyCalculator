package software.eii.ulpgc.psl.moneycalculator;

public record Money(Currency currency, long quantity) {
    @Override
    public String toString() {
        return quantity + " " + currency.code();
    }
}
