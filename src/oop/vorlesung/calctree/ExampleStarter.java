package oop.vorlesung.calctree;

public class ExampleStarter {

	public static void main(String[] args) {
		CalcTree tree = new Multiply(new Value(7.0), new Add(new Value(4.0), new Value(2.0)));
		System.out.println(tree.toString() + " = " + tree.evaluate());
	}
}
