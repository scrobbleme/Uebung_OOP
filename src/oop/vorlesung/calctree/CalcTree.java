package oop.vorlesung.calctree;

public interface CalcTree {
	/**
	 * @return Das Ergebnis der Berechnung des Baums
	 */
	double evaluate();

	/**
	 * @return Die Formel als String.
	 */
	String toString();
}
