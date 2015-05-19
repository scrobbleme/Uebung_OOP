package oop.uebung3.apps;

import java.util.Map;
import java.util.Scanner;

public class AppApp extends AbstractApp {

	private final Map<String, App> apps;
	private final Scanner scanner = new Scanner(System.in);

	public AppApp(Map<String, App> apps) {
		super("appapp", "App, welche andere Apps startet");
		this.apps = apps;
	}

	@Override
	public void process(String... args) {
		apps.get("help").process();
		System.out.println("\nBitte starte eine App:");

		while (true) {
			String next = scanner.nextLine();
			String[] arguments = next.split("\\s+");
			if (arguments.length < 1) {
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
