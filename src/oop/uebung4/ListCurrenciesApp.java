package oop.uebung4;

import oop.uebung3.apps.AbstractApp;

/**
 * Diese App listet alle verfügbaren Währung auf.
 */
public class ListCurrenciesApp extends AbstractApp {

	protected ListCurrenciesApp() {
		super("currencies", "Listet alle Währungen auf die mit freecurrencyconverterapi.com umgerechnet werden können.");
	}

	@Override
	public void process(String[] args) {
		// Lade die Liste der Währungen runter:
		// http://www.freecurrencyconverterapi.com/api/v3/currencies

		// Gebe die Liste sortiert nach Id in der Form ID NAME SYMBOL aus:
		// USD United States Dollar $
	}
}