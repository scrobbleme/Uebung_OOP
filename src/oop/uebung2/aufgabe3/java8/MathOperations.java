package oop.uebung2.aufgabe3.java8;

import java.util.function.BinaryOperator;

/**
 * http://stackoverflow.com/a/28922263/1165132
 */
public enum MathOperations {
	// Lambda
	ADD((left, right) -> (left + right)), 
	SUB((left, right) -> (left - right)), 
	MULT((left, right) -> (left * right)), 
	DIV((left, right) -> (left / right));

	private BinaryOperator<Float> operator;

	private MathOperations(BinaryOperator<Float> operator) {
		this.operator = operator;
	}

	public float calculate(String... args) throws ParameterNotANumberException {
		int i = 1;
		try {
			float result = Float.parseFloat(args[i++]);
			for (; i < args.length; i++) {
				result = operator.apply(result, Float.parseFloat(args[i]));
			}
			return result;
		} catch (NumberFormatException e) {
			throw new ParameterNotANumberException(i);
		}
	}
}
