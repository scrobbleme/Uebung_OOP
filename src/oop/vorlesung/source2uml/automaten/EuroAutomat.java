package oop.vorlesung.source2uml.automaten;

import oop.vorlesung.source2uml.automaten.exceptions.KaufAbgebrochenException;
import oop.vorlesung.source2uml.automaten.exceptions.NotEnoughGeldException;
import oop.vorlesung.source2uml.produkte.Produkt;

public abstract class EuroAutomat<P extends Produkt> implements Automat<P> {

	@Override
	public void sammleGeldEin(P produkt) throws NotEnoughGeldException, KaufAbgebrochenException {
		// Dieser Automato erlaubt nur EURO-Münzen
	}
}
