package oop.uebung2.aufgabe4.math;

public class SubMathOperation extends MathOperation {

	public SubMathOperation() {
		super("sub");
	}

	@Override
	public float calculate(float left, float right) {
		return left - right;
	}

}
