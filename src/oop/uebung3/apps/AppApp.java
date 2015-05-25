package oop.uebung3.apps;

import java.util.Map;

import oop.uebung3.AppStarter;

public class AppApp extends AbstractApp {

	private final Map<String, App> apps;

	public AppApp(Map<String, App> apps) {
		super("appapp", "App, welche andere Apps startet");
		this.apps = apps;
	}

	@Override
	public void process(String... args) {
		apps.get("help").process();
		System.out.println("\nBitte starte eine App:");

		while (true) {
			String next = AppStarter.SCANNER.nextLine();
			String[] arguments = next.trim().split("\\s+");
			if (arguments.length < 1 || arguments[0].length() == 0) {
				continue;
			}
			App app = apps.get(arguments[0]);
			if (app == null) {
				System.out.println("\nDiese App existiert nicht.");
			} else {
				app.process(arguments);
			}
		}
	}
}
