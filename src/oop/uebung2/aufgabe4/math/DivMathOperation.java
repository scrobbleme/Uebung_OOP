package oop.uebung2.aufgabe4.math;

public class DivMathOperation extends MathOperation {

	public DivMathOperation() {
		super("div");
	}

	@Override
	public float calculate(float left, float right) {
		if (right == 0) {
			throw new RuntimeException("Division durch 0 ist nicht erlaubt.");
		}
		return left / right;
	}

}
