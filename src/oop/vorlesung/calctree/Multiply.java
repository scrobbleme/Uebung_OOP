package oop.vorlesung.calctree;

public class Multiply extends BinaryNode {

	public Multiply(CalcTree left, CalcTree right) {
		super(left, right);
	}

	@Override
	public double evaluate() {
		return left.evaluate() + right.evaluate();
	}

	public String toString() {
		return "(" + left.toString() + " * " + right.toString() + ")";
	}
}
