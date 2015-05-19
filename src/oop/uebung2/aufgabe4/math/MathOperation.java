package oop.uebung2.aufgabe4.math;

import oop.uebung2.aufgabe3.ParameterNotANumberException;

/**
 * Abstrakte Oberklasse f�r alle Matheoperationen.
 */
public abstract class MathOperation {

	private final String operationName;

	/**
	 * @param operationName
	 *            Name der Operation, welche die Implementierung ausf�hrt.
	 */
	protected MathOperation(String operationName) {
		this.operationName = operationName;
	}

	/**
	 * @param operation
	 *            Die zu �berpr�fende Operation.
	 * @return True, wenn diese MathOperation die �bergebene Operation ausf�hren
	 *         kann.
	 */
	public boolean isValid(String operation) {
		return operation != null && operation.equalsIgnoreCase(operationName);
	}

	/**
	 * @param args
	 *            Alle Argumente. Das erste Argument ist die Operation.
	 * @return Das Ergebnis.
	 * @throws ParameterNotANumberException
	 *             Tritt auf, wenn ein Wert keine g�ltige Zahl ist.
	 */
	public float rechne(String... args) throws ParameterNotANumberException {
		int i = 1;
		try {
			float result = Float.parseFloat(args[i++]);
			for (; i < args.length; i++) {
				result = calculate(result, Float.parseFloat(args[i]));
			}
			return result;
		} catch (NumberFormatException e) {
			throw new ParameterNotANumberException(i);
		}
	}

	/**
	 * @param left
	 *            Wert 1
	 * @param right
	 *            Wert 2
	 * @return Das berechnete Ergebnis der beiden Werte.
	 */
	public abstract float calculate(float left, float right);
}
