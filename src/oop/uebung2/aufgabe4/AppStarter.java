package oop.uebung2.aufgabe4;

import java.util.ArrayList;
import java.util.List;

import oop.uebung2.aufgabe3.ParameterNotANumberException;
import oop.uebung2.aufgabe4.math.AddMathOperation;
import oop.uebung2.aufgabe4.math.DivMathOperation;
import oop.uebung2.aufgabe4.math.MathOperation;
import oop.uebung2.aufgabe4.math.MultMathOperation;
import oop.uebung2.aufgabe4.math.SubMathOperation;

public class AppStarter {

	private final static List<MathOperation> MATH_OPERATIONS = new ArrayList<>();

	static {
		MATH_OPERATIONS.add(new AddMathOperation());
		MATH_OPERATIONS.add(new SubMathOperation());
		MATH_OPERATIONS.add(new MultMathOperation());
		MATH_OPERATIONS.add(new DivMathOperation());
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
