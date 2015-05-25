package oop.uebung4.aufgabe2_jackson;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

import oop.uebung3.apps.AbstractApp;
import oop.uebung4.aufgabe2_jackson.model.CurrenciesApiResult;
import oop.uebung4.aufgabe2_jackson.model.Currency;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Diese App listet alle verfügbaren Währung auf.
 * 
 * Sie verwendet dabei die Jackson-Bibliothek, um JSON besser parsen zu können.
 */
public class ListCurrenciesApp extends AbstractApp {

	public ListCurrenciesApp() {
		super("currencies", "Listet alle Währungen auf die mit freecurrencyconverterapi.com umgerechnet werden können.");
	}

	@Override
	public void process(String... args) {
		// Lade die Liste der Währungen runter:
		// http://www.freecurrencyconverterapi.com/api/v3/currencies
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// Lasse die Jackson-Bibliothek den JSON-String in eine
			// Objektstruktur umwandeln.
			CurrenciesApiResult apiResult = objectMapper.readValue(new URL(
			        "http://www.freecurrencyconverterapi.com/api/v3/currencies"), CurrenciesApiResult.class);

			Map<String, Currency> currencies = new TreeMap<String, Currency>(apiResult.getResults());

			// Gebe die Liste sortiert nach Id in der Form ID NAME SYMBOL aus:
			for (Currency currency : currencies.values()) {
				System.out.println(currency.getId() + "\t"
				        + (currency.getCurrencySymbol() == null ? "" : currency.getCurrencySymbol()) + "\t"
				        + currency.getCurrencyName());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}