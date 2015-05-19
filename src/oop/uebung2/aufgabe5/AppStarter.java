package oop.uebung2.aufgabe5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

import oop.uebung2.aufgabe3.ParameterNotANumberException;
import oop.uebung2.aufgabe5.MathOperation;

public class AppStarter {

	private final static List<MathOperation> MATH_OPERATIONS = new ArrayList<>();

	static {
		MATH_OPERATIONS.add(new MathOperation("add", (left, right) -> (left + right)));
		MATH_OPERATIONS.add(new MathOperation("sub", (left, right) -> (left - right)));
		MATH_OPERATIONS.add(new MathOperation("mult", (left, right) -> (left * right)));

		// Division ist etwas umfangreicher.
		BinaryOperator<Float> division = (left, right) -> {
			if (right == 0) {
				throw new RuntimeException("Division durch 0 ist nicht erlaubt");
			}
			return left / right;
		};

		MATH_OPERATIONS.add(new MathOperation("div", division));
		MATH_OPERATIONS.add(new MathOperation("/", division));
		MATH_OPERATIONS.add(new MathOperation(":", division));
	}

	public static void main(String... args) {
		if (args.length < 3) {
			System.out.println("Bitte mindestens 3 Werte angeben");
			return;
		}

		for (MathOperation operation : MATH_OPERATIONS) {
			// Finde eine passende Implementierung
			if (operation.isValid(args[0])) {
				try {

					// Hier wird gerechnet.
					System.out.println("Das Ergebnis ist " + operation.rechne(args));

				} catch (ArithmeticException e) {
					System.out.println("Division durch 0 ist nicht erlaubt.");
				} catch (ParameterNotANumberException e) {
					System.out.println("Der Parameter " + e.getIndex() + " ist keine Zahl.");
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
				return;
			}
		}
		System.out.println("Bitte eine gültige Rechenart angeben");
	}
}
