package oop.uebung4.aufgabe4_ui;

import oop.uebung4.aufgabe3_caching.CachingCurrencyConverterApp;

public class CurrencyConvertUIApp extends CachingCurrencyConverterApp {

	public CurrencyConvertUIApp() {
		super("currencyui", "Oberfl�che, um W�hrungen zu konvertieren");
	}

	@Override
	public void process(String... args) {
		ConverterUI.main(new String[0]);
	}
}
