package software.eii.ulpgc.psl.moneycalculator.fixerapi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import software.eii.ulpgc.psl.moneycalculator.Currency;
import software.eii.ulpgc.psl.moneycalculator.ExchangeRate;
import software.eii.ulpgc.psl.moneycalculator.ExchangeRateLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public class FixerExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to, LocalDate date) {
        try {
            return toExchangeRate(loadJson(from, to, date), from, to, date);
        } catch (Exception e) {
            return new ExchangeRate(from, to, -1, date);
        }
    }

    private ExchangeRate toExchangeRate(String json, Currency from, Currency to, LocalDate date) throws Exception{
        Map<String, JsonElement> rates = new Gson().fromJson(json, JsonObject.class).get("rates").getAsJsonObject().asMap();
        double rateFrom = rates.get(from.code()).getAsDouble();
        double rateTo = rates.get(to.code()).getAsDouble();
        return new ExchangeRate(from, to, rateTo/rateFrom, date);
    }

    private String loadJson(Currency currencyFrom, Currency currencyTo, LocalDate date) throws IOException {
        URL url = new URL("http://data.fixer.io/api/" + date.toString() +
                "?access_key=" + FixerAuthentication.key +
                "&symbols=" + currencyFrom.code() + "," + currencyTo.code());
        try (InputStream inputStream = url.openStream()) {
            return new String(inputStream.readAllBytes());
        }
    }
}
