package oop.uebung4;

import oop.uebung3.apps.AbstractApp;

/**
 * Diese App soll einen eingebenen Betrag von einer Währung in eine andere
 * umwandeln.
 */
public class CurrencyConverterApp extends AbstractApp {

	protected CurrencyConverterApp() {
		super("convert", "Rechnet von einer Währung in eine andere mit Hilfe von freecurrencyconverterapi.com");
	}

	@Override
	public void process(String[] args) {
		// 1. Frage den Nutzer nach folgenden Werter
		//    a. Ausgangswährung
		//    b. Zielwährung
		//    c. Betrag der konvertiert werden soll (ganze Zahl)

		// 2. Lade den aktuellen Wechselkurs runter, z.B.
		// http://www.freecurrencyconverterapi.com/api/v3/convert?q=EUR_USD&compact=y

		// 3. Gib den aktuellen Wechselkurs für 1 Geldeinheit aus
		// 4. Gib das Ergebnis für den eingegeben Betrag an
	}
}