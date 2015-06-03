package oop.vorlesung.source2uml.produkte.getr�nke;

public abstract class AlkoholischesGetr�nk extends Getr�nk {
	private final double alkoholgehalt;

	public AlkoholischesGetr�nk(String name, double preis, double alkoholgehalt) {
		super(name, preis, alkoholgehalt > 10 ? 18 : 16);
		this.alkoholgehalt = alkoholgehalt;
	}

	public double getAlkoholgehalt() {
		return alkoholgehalt;
	}

}
