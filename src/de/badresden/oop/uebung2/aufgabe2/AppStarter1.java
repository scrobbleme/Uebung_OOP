package de.badresden.oop.uebung2.aufgabe2;

/**
 * Wo ist der Fehler?
 *
 */
public class AppStarter1 {

	public static void main(String... args) {
		if (args.length < 3) {
			System.out.println("Bitte mindestens 3 Werte angeben");
			return;
		}
		String rechenart = args[0].toLowerCase();
		if (!rechenart.matches("add|sub|mult|div")) {
			System.out.println("Bitte eine gültige Rechenart angeben");
			return;
		}

		float result = Float.parseFloat(args[1]);
		for (int i = 2; i < args.length; i++) {
			try {
				float value = Float.parseFloat(args[i]);
				if ("div".equals(rechenart) && value == 0) {
					System.out.println("Division durch 0 ist nicht erlaubt");
					return;
				}
				switch (rechenart) {
				case "add":
				case "+":
					result += value;
					break;
				case "sub":
				case "-":
					result -= value;
					break;
				case "mult":
				case "*":
					result *= value;
					break;
				case "div":
				case "/":
				case ":":
					result /= value;
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("Parameter " + (i + 1) + " ist leider keine Zahl: " + args[i]);
				return;
			}
		}
		System.out.println("Das Ergebnis ist " + result);
	}
}
