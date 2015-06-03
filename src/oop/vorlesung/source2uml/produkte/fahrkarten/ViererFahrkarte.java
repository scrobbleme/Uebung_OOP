package oop.vorlesung.source2uml.produkte.fahrkarten;

public class ViererFahrkarte extends EinzelFahrkarte {

	public ViererFahrkarte() {
		super("4er Karte");
	}

	@Override
	public double getPreis() {
		// Preis = 4 mal der Einzelpreis und dann 10% Rabatt
		return super.getPreis() * 4 * 0.9;
	}

}
