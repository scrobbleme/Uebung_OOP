package oop.vorlesung.source2uml.produkte.getr�nke;

public class MilchGetr�nk extends Getr�nk {

	public MilchGetr�nk() {
		this("Milch", 1);
	}

	public MilchGetr�nk(String name, double preis) {
		super(name, preis, 0);
	}

}
