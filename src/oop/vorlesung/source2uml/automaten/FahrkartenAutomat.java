package oop.vorlesung.source2uml.automaten;

import oop.vorlesung.source2uml.automaten.exceptions.KaufAbgebrochenException;
import oop.vorlesung.source2uml.automaten.exceptions.ProduktAusverkauftException;
import oop.vorlesung.source2uml.automaten.exceptions.ProduktNotFoundException;
import oop.vorlesung.source2uml.produkte.fahrkarten.Fahrkarte;

public class FahrkartenAutomat extends EuroAutomat<Fahrkarte> {

	@Override
	public Fahrkarte frageNachProdukt() throws ProduktNotFoundException, ProduktAusverkauftException,
	        KaufAbgebrochenException {
		// TODO Das müssen wir noch implementieren
		return null;
	}

	@Override
	public void gibWareAus(Fahrkarte produkt) {
		// Der Fahrschein muss gedruckt werden
	}

}
