package oop.uebung3;

import java.util.Map;
import java.util.TreeMap;

import oop.uebung3.apps.App;

public class AppStarter {

	private static final Map<String, App> APPS = new TreeMap<>();

	static {
		// 1. Registriere bestehende Apps
		// APPS.put(app.getName(), app);
	}

	public static void main(String... args) {
		if (args.length < 1) {
			// TODO Starte the HelpApp
			return;
		}
		App app = APPS.get(args[0]);
		if (app == null) {
			System.out.println("\nDiese App existiert nicht.");
			// TODO Starte the HelpApp
		} else {
			app.process(args);
		}
	}
}
