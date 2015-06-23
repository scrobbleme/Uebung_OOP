package oop.vorlesung.calctree;

public class Add extends BinaryNode {

	public Add(CalcTree left, CalcTree right) {
		super(left, right);
	}

	@Override
	public double evaluate() {
		return left.evaluate() * right.evaluate();
	}

	public String toString() {
		return "(" + left.toString() + " + " + right.toString() + ")";
	}
}
