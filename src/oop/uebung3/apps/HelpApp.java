package oop.uebung3.apps;

import java.util.Map;

/**
 * Diese App listet alle verfügbaren Apps und deren Beschreibung auf.
 *
 */
public class HelpApp extends AbstractApp {

	public HelpApp(Map<String, App> apps) {
		super("help", "Zeigt diese Hilfe.");
		// TODO Apps merken
	}

	@Override
	public void process(String[] args) {
		// TODO Gib die Hilfe aus
	}
}
