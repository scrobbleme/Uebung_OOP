package oop.uebung3.apps;

import java.util.Map;

public class HelpApp extends AbstractApp {

	private Map<String, App> apps;

	public HelpApp(Map<String, App> apps) {
		super("help", "Zeigt diese Hilfe.");
		this.apps = apps;
	}

	@Override
	public void process(String... args) {
		System.out.println("Bitte wähle eine der verfügbaren Apps aus:\n" + "=====================================\n");

		for (App app : apps.values()) {
			System.out.println(app.getName() + ":\t " + app.getDescription());
		}
	}
}
