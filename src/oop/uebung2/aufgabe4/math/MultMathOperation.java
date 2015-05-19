package oop.uebung2.aufgabe4.math;

public class MultMathOperation extends MathOperation {

	public MultMathOperation() {
		super("mult");
	}

	@Override
	public float calculate(float left, float right) {
		return left * right;
	}

}
