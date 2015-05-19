package oop.uebung2.aufgabe5;

import java.util.function.BinaryOperator;

import oop.uebung2.aufgabe3.ParameterNotANumberException;

/**
 * 
 */
public class MathOperation {

	private final String operationName;
	private BinaryOperator<Float> operator;

	/**
	 * @param operationName
	 *            Name der Operation, welche die Implementierung ausf�hrt.
	 * @param operator
	 *            Die Operation, welche ausgef�hrt werden soll.
	 */
	protected MathOperation(String operationName, BinaryOperator<Float> operator) {
		this.operationName = operationName;
		this.operator = operator;
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

				// Rufe nun den BinaryOperator auf, um das Ergebnis zu
				// berechnen.
				result = operator.apply(result, Float.parseFloat(args[i]));
			}
			return result;
		} catch (NumberFormatException e) {
			throw new ParameterNotANumberException(i);
		}
	}

}
