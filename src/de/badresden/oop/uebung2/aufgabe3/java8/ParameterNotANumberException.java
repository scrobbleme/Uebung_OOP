package de.badresden.oop.uebung2.aufgabe3.java8;

public class ParameterNotANumberException extends Exception {

	private static final long serialVersionUID = -732782141870328133L;

	private int index;

	public ParameterNotANumberException(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
