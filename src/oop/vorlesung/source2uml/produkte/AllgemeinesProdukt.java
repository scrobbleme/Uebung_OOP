package oop.vorlesung.source2uml.produkte;

public abstract class AllgemeinesProdukt implements Produkt {

	private final String name;
	private final double preis;

	public AllgemeinesProdukt(String name, double preis) {
		this.name = name;
		this.preis = preis;
	}

	public String getName() {
		return name;
	}

	public double getPreis() {
		return preis;
	}

}
