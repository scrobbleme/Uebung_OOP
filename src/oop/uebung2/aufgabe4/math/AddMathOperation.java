package oop.uebung2.aufgabe4.math;

public class AddMathOperation extends MathOperation {

	public AddMathOperation() {
		super("add");
	}

	@Override
	public float calculate(float left, float right) {
		return left + right;
	}

}
