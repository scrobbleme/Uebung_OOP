package de.badresden.oop.uebung2.aufgabe1;

public class AppStarter1RegExp {

	public static void main(String... args) {
		if (args.length < 2) {
			System.out.println("Bitte mindestens 2 Werte angeben.");
			return; // Return early
		}
		float result = 0;
		for (int i = 0; i < args.length; i++) {
			if (!args[i].matches("[0-9]+|\\d+\\.\\d+")) {
				System.out.println("Parameter " + (i + 1) + " ist leider keine Zahl: " + args[i]);
				return;
			}
			result += Float.parseFloat(args[i]);
		}
		System.out.println("Das Ergebnis ist " + result);
	}
}
