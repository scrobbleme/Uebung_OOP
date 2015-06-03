package oop.vorlesung.source2uml.produkte.getränke;

public class MilchGetränk extends Getränk {

	public MilchGetränk() {
		this("Milch", 1);
	}

	public MilchGetränk(String name, double preis) {
		super(name, preis, 0);
	}

}
