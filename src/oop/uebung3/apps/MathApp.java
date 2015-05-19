package oop.uebung3.apps;

import oop.uebung2.aufgabe3.MathOperations;
import oop.uebung2.aufgabe3.ParameterNotANumberException;

/**
 * Die MathApp stellt eine Schnittstelle zum enum {@link MathOperations} bereit
 * und berechnet das Ergebnis mit dessen Hilfe.
 */
public class MathApp extends StreamableApp {

	private MathOperations operation;

	public MathApp(MathOperations operation) {
		super(operation.name().toLowerCase(), "Diese App stellt die Operation " + operation.name() + " bereit.");
		this.operation = operation;
	}

	@Override
	public void process(String... args) {
		if (args.length < 3) {
			getOutputStream().println("Bitte mindestens 3 Werte angeben");
			return;
		}
		try {
			getOutputStream().println("Das Ergebnis ist " + operation.rechne(args));
		} catch (ArithmeticException e) {
			getOutputStream().println("Division durch 0 ist nicht erlaubt.");
		} catch (ParameterNotANumberException e) {
			getOutputStream().println("Der Parameter " + e.getIndex() + " ist keine Zahl.");
		} catch (RuntimeException e) {
			getOutputStream().println(e.getMessage());
		}
	}

}
