package oop.vorlesung.source2uml.automaten.muenzen;

public abstract class AbstrakteMuenze implements Muenze {

	private final String waehrung;
	private final double wert;

	protected AbstrakteMuenze(String waehrung, double wert) {
		this.waehrung = waehrung;
		this.wert = wert;
	}

	public String getWaehrung() {
		return waehrung;
	}

	public double getWert() {
		return wert;
	}

}
