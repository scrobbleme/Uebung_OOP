package oop.vorlesung.source2uml.produkte.fahrkarten;

public class EinzelFahrkarte extends Fahrkarte {

	public EinzelFahrkarte() {
		this("Einzelfahrt");
	}

	public EinzelFahrkarte(String name) {
		this(name, 2.00);
	}

	public EinzelFahrkarte(String name, double preis) {
		super(name, preis);
	}

}
