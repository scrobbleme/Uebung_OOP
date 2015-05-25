package oop.uebung4.aufgabe1;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import oop.uebung3.AppStarter;
import oop.uebung3.apps.AbstractApp;

/**
 * Diese App soll einen eingebenen Betrag von einer Währung in eine andere
 * umwandeln.
 */
public class CurrencyConverterApp extends AbstractApp {

	public CurrencyConverterApp() {
		super("convert", "Rechnet von einer Währung in eine andere mit Hilfe von freecurrencyconverterapi.com");
	}

	@Override
	public void process(String... args) {
		String sourceCurrency;
		String targetCurrency;
		String apiResult;
		int betrag;

		// 1. Frage den Nutzer nach folgenden Werter
		// a. Ausgangswährung
		// b. Zielwährung
		// c. Betrag der konvertiert werden soll (ganze Zahl)
		System.out.print("Ausgangswährung: ");
		sourceCurrency = AppStarter.SCANNER.nextLine().toUpperCase();
		System.out.print("Zielwährung: ");
		targetCurrency = AppStarter.SCANNER.nextLine().toUpperCase();
		System.out.print("Betrag: ");
		betrag = AppStarter.SCANNER.nextInt();

		// 2. Lade den aktuellen Wechselkurs runter, z.B.
		String url = "http://www.freecurrencyconverterapi.com/api/v3/convert?compact=y&q=" + sourceCurrency + "_"
		        + targetCurrency;
		System.out.println("\nLade Daten runter. Bitte warten.\n");
		try (Scanner urlScanner = new Scanner(new URL(url).openStream())) {
			apiResult = urlScanner.nextLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// 3. Gib den aktuellen Wechselkurs für 1 Geldeinheit aus
		String rateAsString = apiResult.substring(apiResult.indexOf("val\":") + 5, apiResult.length() - 2);
		System.out.println("1 " + sourceCurrency + "\t=\t" + rateAsString + " " + targetCurrency);

		// 4. Gib das Ergebnis für den eingegeben Betrag an
		Double rate = Double.parseDouble(rateAsString);
		System.out.println(betrag + " " + sourceCurrency + "\t=\t" + (betrag * rate) + " " + targetCurrency);
	}
}