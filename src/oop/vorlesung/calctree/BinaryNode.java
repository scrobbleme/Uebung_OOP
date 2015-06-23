package oop.vorlesung.calctree;

public abstract class BinaryNode implements CalcTree {
	protected CalcTree left;
	protected CalcTree right;

	public BinaryNode(CalcTree left, CalcTree right) {
		if (left == null) {
			throw new RuntimeException("Left may not be null");
		}
		if (right == null) {
			throw new RuntimeException("Right may not be null");
		}

		this.left = left;
		this.right = right;
	}
}
