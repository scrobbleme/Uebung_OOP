package de.badresden.oop.uebung2.aufgabe1;

public class AppStarter1 {

	public static void main(String... args) {
		if (args.length < 2) {
			System.out.println("Bitte mindestens 2 Werte angeben.");
			return; // Return early
		}
		float result = 0;
		for (int i = 0; i < args.length; i++) {
			try {
				result += Float.parseFloat(args[i]);
			} catch (NumberFormatException e) {
				System.out.println("Parameter " + (i + 1) + " ist leider keine Zahl: " + args[i]);
				return;
			}
		}
		System.out.println("Das Ergebnis ist " + result);
	}
}
