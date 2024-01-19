package software.eii.ulpgc.psl.moneycalculator.Model;

public record Money(Currency currency, double quantity) {
    @Override
    public String toString() {
        return quantity + " " + currency.code();
    }
}
