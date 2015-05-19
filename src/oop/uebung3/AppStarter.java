package oop.uebung3;

import java.util.Map;
import java.util.TreeMap;

import oop.uebung2.aufgabe3.MathOperations;
import oop.uebung3.apps.App;
import oop.uebung3.apps.AppApp;
import oop.uebung3.apps.ExitApp;
import oop.uebung3.apps.Help8App;
import oop.uebung3.apps.HelpApp;
import oop.uebung3.apps.MathApp;
import oop.uebung3.apps.ui.UIApp;

public class AppStarter {

	private static final Map<String, App> APPS = new TreeMap<>();

	static {
		// Registriere eine Matheapp f�r jede Operation
		for (MathOperations operation : MathOperations.values()) {
			registerApp(new MathApp(operation));
		}

		// Registriere die �brigen Apps.
		registerApp(new HelpApp(APPS));
		registerApp(new Help8App(APPS));
		registerApp(new AppApp(APPS));
		registerApp(new ExitApp());
		registerApp(new UIApp(APPS));
	}

	public static void main(String... args) {
		if (args.length < 1) {
			APPS.get("help").process(args);
			return;
		}
		App app = APPS.get(args[0]);
		if (app == null) {
			System.out.println("\nDiese App existiert nicht.");
			APPS.get("help").process(args);
		} else {
			app.process(args);
		}
	}

	public static void registerApp(App app) {
		APPS.put(app.getName(), app);
	}
}
