package oop.uebung3.apps;

import java.util.Scanner;

public class ProvokeScannerExceptionApp extends AbstractApp {

	public ProvokeScannerExceptionApp() {
		super("scanner_exception", "Erzeugt einen Fehler mit dem Scanner.");
	}

	@Override
	public void process(String... args) {
		// Dieser Block erzeugt ein NoSuchElementExeption.
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(scanner.getClass());
		}
	}
}
