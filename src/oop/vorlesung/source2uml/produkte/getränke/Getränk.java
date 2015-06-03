package oop.vorlesung.source2uml.produkte.getr�nke;

import oop.vorlesung.source2uml.produkte.AllgemeinesProdukt;

public abstract class Getr�nk extends AllgemeinesProdukt {

	private final int minimalesVerkaufsalter;

	public Getr�nk(String name, double preis) {
		this(name, preis, 18);
	}

	public Getr�nk(String name, double preis, int minimalesVerkaufsalter) {
		super(name, preis);
		this.minimalesVerkaufsalter = minimalesVerkaufsalter;
	}

	public int getMinimalesVerkaufsalter() {
		return minimalesVerkaufsalter;
	}
	

}
