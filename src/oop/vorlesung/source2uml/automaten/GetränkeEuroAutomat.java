package oop.vorlesung.source2uml.automaten;

import oop.vorlesung.source2uml.automaten.exceptions.KaufAbgebrochenException;
import oop.vorlesung.source2uml.automaten.exceptions.ProduktAusverkauftException;
import oop.vorlesung.source2uml.automaten.exceptions.ProduktNotFoundException;
import oop.vorlesung.source2uml.produkte.getränke.Getränk;

public class GetränkeEuroAutomat extends EuroAutomat<Getränk> {

	@Override
	public Getränk frageNachProdukt() throws ProduktNotFoundException, ProduktAusverkauftException,
	        KaufAbgebrochenException {
		Getränk getränk = null;
		// Welches Getränk darf es bitte sein?
		// Alkoholisches Getränk? Bitte noch Ausweis zeigen.
		return getränk;
	}

	@Override
	public void gibWareAus(Getränk produkt) {
		// Schiebe das Produkt in die Ausgabe
	}

}
