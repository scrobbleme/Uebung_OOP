package oop.uebung3.apps;

import java.util.Map;

public class Help8App extends AbstractApp {

	private Map<String, App> apps;

	public Help8App(Map<String, App> apps) {
		super("help8", "Zeigt die Hilfe mit Hilfe von Java 8 Lambda-Ausdr�cken.");
		this.apps = apps;
	}

	@Override
	public void process(String... args) {
		System.out.println("Bitte w�hle eine der verf�gbaren aus:\n" + "=====================================");

		// Java 8 ;)
		apps.values().forEach(app -> (System.out.println(app.getName() + ":\t " + app.getDescription())));
	}
}
