package oop.vorlesung.source2uml.produkte.getränke;

public abstract class AlkoholischesGetränk extends Getränk {
	private final double alkoholgehalt;

	public AlkoholischesGetränk(String name, double preis, double alkoholgehalt) {
		super(name, preis, alkoholgehalt > 10 ? 18 : 16);
		this.alkoholgehalt = alkoholgehalt;
	}

	public double getAlkoholgehalt() {
		return alkoholgehalt;
	}

}
