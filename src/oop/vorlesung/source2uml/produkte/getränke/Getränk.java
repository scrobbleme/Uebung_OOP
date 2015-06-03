package oop.vorlesung.source2uml.produkte.getränke;

import oop.vorlesung.source2uml.produkte.AllgemeinesProdukt;

public abstract class Getränk extends AllgemeinesProdukt {

	private final int minimalesVerkaufsalter;

	public Getränk(String name, double preis) {
		this(name, preis, 18);
	}

	public Getränk(String name, double preis, int minimalesVerkaufsalter) {
		super(name, preis);
		this.minimalesVerkaufsalter = minimalesVerkaufsalter;
	}

	public int getMinimalesVerkaufsalter() {
		return minimalesVerkaufsalter;
	}
	

}
