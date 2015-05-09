package de.badresden.oop.uebung2.aufgabe1;

import java.math.BigDecimal;

public class AppStarter2 {

	public static void main(String... args) {
		if (args.length < 2) {
			System.out.println("Bitte mindestens 2 Werte angeben.");
			return; // Return early
		}
		int maxNumbersAfterPoint = 0;
		float result = 0;
		for (int i = 0; i < args.length; i++) {
			try {
				result += Float.parseFloat(args[i]);
				maxNumbersAfterPoint = getMaxNumbersAfterPoint(maxNumbersAfterPoint, args[i]);
			} catch (NumberFormatException e) {
				System.out.println("Parameter " + (i + 1) + " ist leider keine Zahl: " + args[i]);
				return;
			}
		}
		// Thanks http://stackoverflow.com/a/8911683/1165132
		BigDecimal bigDecimal = new BigDecimal(Float.toString(result));
		bigDecimal = bigDecimal.setScale(maxNumbersAfterPoint, BigDecimal.ROUND_HALF_UP);
		result = bigDecimal.floatValue();
		System.out.println("Das Ergebnis ist " + result);
	}

	/**
	 * @param maxNumbersAfterPoint
	 *            Current value.
	 * @param argument
	 *            The value to eventually extract the new value
	 * @return The new value.
	 */
	private static int getMaxNumbersAfterPoint(int maxNumbersAfterPoint, String argument) {
		String[] splittedArgument = argument.split("\\.");
		if (splittedArgument.length >= 2 && splittedArgument[1].length() > maxNumbersAfterPoint) {
			return splittedArgument[1].length();
		}
		return maxNumbersAfterPoint;
	}
}
