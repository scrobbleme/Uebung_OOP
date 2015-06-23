package oop.vorlesung.source2uml.automaten;

import oop.vorlesung.source2uml.automaten.exceptions.KaufAbgebrochenException;
import oop.vorlesung.source2uml.automaten.exceptions.NotEnoughGeldException;
import oop.vorlesung.source2uml.automaten.exceptions.ProduktAusverkauftException;
import oop.vorlesung.source2uml.automaten.exceptions.ProduktNotFoundException;
import oop.vorlesung.source2uml.produkte.Produkt;

public interface Automat<P extends Produkt> {

	public P frageNachProdukt() throws ProduktNotFoundException, ProduktAusverkauftException, KaufAbgebrochenException;

	public void sammleGeldEin(P produkt) throws NotEnoughGeldException, KaufAbgebrochenException;

	public void gibWareAus(P produkt);
}
