package software.eii.ulpgc.psl.moneycalculator.Model;

public record Currency(String code, String name) {
    @Override
    public String toString() {
        return code + ":" + name;
    }
}
