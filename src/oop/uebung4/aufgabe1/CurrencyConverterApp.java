package oop.uebung4.aufgabe1;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import oop.uebung3.AppStarter;
import oop.uebung3.apps.AbstractApp;

/**
 * Diese App soll einen eingebenen Betrag von einer W�hrung in eine andere
 * umwandeln.
 */
public class CurrencyConverterApp extends AbstractApp {

	public CurrencyConverterApp() {
		super("convert", "Rechnet von einer W�hrung in eine andere mit Hilfe von freecurrencyconverterapi.com");
	}

	public CurrencyConverterApp(String name, String description) {
		super(name, description);
	}
	
	@Override
	public void process(String... args) {
		String sourceCurrency;
		String targetCurrency;
		int betrag;

		// 1. Frage den Nutzer nach folgenden Werter
		// a. Ausgangsw�hrung
		// b. Zielw�hrung
		// c. Betrag der konvertiert werden soll (ganze Zahl)
		System.out.print("Ausgangsw�hrung: ");
		sourceCurrency = AppStarter.SCANNER.nextLine().toUpperCase();
		System.out.print("Zielw�hrung: ");
		targetCurrency = AppStarter.SCANNER.nextLine().toUpperCase();
		System.out.print("Betrag: ");
		betrag = AppStarter.SCANNER.nextInt();

		// 2. Lade den aktuellen Wechselkurs runter, z.B.
		Double rate = getRate(sourceCurrency, targetCurrency);

		// 4. Gib das Ergebnis f�r den eingegeben Betrag an
		System.out.println(betrag + " " + sourceCurrency + "\t=\t" + (betrag * rate) + " " + targetCurrency);
	}

	/**
	 * Hohlt den aktuellen Wechselkurs aus dem Cache oder l�dt ihn aus dem
	 * Internet herunter.
	 * 
	 * @param sourceCurrency
	 *            Die Ausgangsw�hrung
	 * @param targetCurrency
	 *            Die Zielw�hrung.
	 * @return Der aktuelle Wechselkurs
	 */
	public double getRate(String sourceCurrency, String targetCurrency) {
		String url = "http://www.freecurrencyconverterapi.com/api/v3/convert?compact=y&q=" + sourceCurrency + "_"
		        + targetCurrency;
		System.out.println("\nLade Daten runter. Bitte warten.\n");
		String apiResult;
		try (Scanner urlScanner = new Scanner(new URL(url).openStream())) {
			apiResult = urlScanner.nextLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// Gib den aktuellen Wechselkurs f�r 1 Geldeinheit aus
		String rateAsString = apiResult.substring(apiResult.indexOf("val\":") + 5, apiResult.length() - 2);
		System.out.println("1 " + sourceCurrency + "\t=\t" + rateAsString + " " + targetCurrency);
		return Double.parseDouble(rateAsString);
	}
}