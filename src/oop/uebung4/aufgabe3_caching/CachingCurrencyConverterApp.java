package oop.uebung4.aufgabe3_caching;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import oop.uebung3.apps.AbstractApp;

/**
 * Diese App soll einen eingebenen Betrag von einer W�hrung in eine andere
 * umwandeln.
 */
public class CachingCurrencyConverterApp extends AbstractApp {

	public CachingCurrencyConverterApp() {
		super("convert_with_cache",
		        "Rechnet von einer W�hrung in eine andere mit Hilfe von freecurrencyconverterapi.com");
	}

	@Override
	public void process(String... args) {
		String sourceCurrency;
		String targetCurrency;
		int betrag;

		// 1. Frage den Nutzer nach folgenden Werten
		// a. Ausgangsw�hrung
		// b. Zielw�hrung
		// c. Betrag der konvertiert werden soll (ganze Zahl)
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Ausgangsw�hrung: ");
			sourceCurrency = scanner.nextLine().toUpperCase();
			System.out.print("Zielw�hrung: ");
			targetCurrency = scanner.nextLine().toUpperCase();
			System.out.print("Betrag: ");
			betrag = scanner.nextInt();
		}

		// 2. Lade den aktuellen Wechselkurs runter bzw. aus dem Cache
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
	private double getRate(String sourceCurrency, String targetCurrency) {
		Double rate = getRateFromCache(sourceCurrency, targetCurrency);
		if (rate == null) {
			rate = getRateFromWeb(sourceCurrency, targetCurrency);
			storeRateInCache(sourceCurrency, targetCurrency, rate);
		}
		return rate;

	}

	/**
	 * L�dt den aktuellen Kurs aus dem Cache herunter.
	 * 
	 * @param sourceCurrency
	 *            Die Ausgangsw�hrung
	 * @param targetCurrency
	 *            Die Zielw�hrung.
	 * @return Den aktuellen Kurs oder "null", wenn im Cache keiner gefunden
	 *         wurde.
	 */
	private Double getRateFromCache(String sourceCurrency, String targetCurrency) {
		// Gibt es die Datei, welche den Kurs enth�lt?
		// -> Ja -> ist die Datei j�nger als 30 Minuten?
		// Ja -> �ffne die Datei und lade den enthalten Kurs
		// Wird eine der Frage mit "Nein" beantwortet -> Gib null zur�ck
		return null;
	}

	/**
	 * Speichert den aktuellen Kurs im Cache.
	 * 
	 * @param sourceCurrency
	 *            Die Ausgangsw�hrung
	 * @param targetCurrency
	 *            Die Zielw�hrung.
	 * @param rate
	 *            Der Kurs zum speichern.
	 */
	private void storeRateInCache(String sourceCurrency, String targetCurrency, Double rate) {
		// Schreibe den Wert in die entsprechende Datei. Gibt es die Datei
		// bereits, dann �berschreibe sie.
		System.out.println("Der neue Wechselkurs wurde im Cache gespeichert.");
	}

	/**
	 * L�dt den aktuellen Kurs aus dem Internet herunter.
	 * 
	 * @param sourceCurrency
	 *            Die Ausgangsw�hrung
	 * @param targetCurrency
	 *            Die Zielw�hrung.
	 * @return Der aktuelle Wechselkurs
	 */
	private Double getRateFromWeb(String sourceCurrency, String targetCurrency) {
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