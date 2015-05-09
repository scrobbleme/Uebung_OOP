package oop.uebung2.aufgabe3.java8;

public class AppStarter1 {

	public static void main(String... args) {
		if (args.length < 3) {
			System.out.println("Bitte mindestens 3 Werte angeben");
			return;
		}
		try {
			MathOperations operation = MathOperations.valueOf(args[0].toUpperCase());
			System.out.println("Das Ergebnis ist " + operation.calculate(args));
		} catch (IllegalArgumentException e) {
			System.out.println("Bitte eine gültige Rechenart angeben");
		} catch (ArithmeticException e) {
			System.out.println("Division durch 0 ist nicht erlaubt.");
		} catch (ParameterNotANumberException e) {
			System.out.println("Der Parameter " + e.getIndex() + " ist keine Zahl.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}
