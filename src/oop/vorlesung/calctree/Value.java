package oop.vorlesung.calctree;

public class Value implements CalcTree {

	private double value;

	public Value(double value) {
		this.value = value;
	}

	@Override
	public double evaluate() {
		return value;
	}

	@Override
	public String toString() {
		return "" + value;
	}

}
