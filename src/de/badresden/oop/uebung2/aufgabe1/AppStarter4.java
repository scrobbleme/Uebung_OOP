package de.badresden.oop.uebung2.aufgabe1;

public class AppStarter4 {

	public static void main(String[] args) {
		rechne();
		rechne((String[]) null);
		rechne(new String[] { "1", "2", "3" });
		rechne("a", "2", "3");
		rechne(new String[] { "1", "b", "3" });
		rechne(new String[] { "1", "2", "c" });
		rechne(new String[] { "0.9", "20", "0.3" });
		rechne("1", "2", "3");

	}

	private static void rechne( String... args) {
		if (args == null || args.length < 2) {
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
