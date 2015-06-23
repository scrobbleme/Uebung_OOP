package oop.vorlesung.source2uml.automaten;

import oop.vorlesung.source2uml.automaten.exceptions.KaufAbgebrochenException;
import oop.vorlesung.source2uml.automaten.exceptions.ProduktAusverkauftException;
import oop.vorlesung.source2uml.automaten.exceptions.ProduktNotFoundException;
import oop.vorlesung.source2uml.produkte.getr�nke.Getr�nk;

public class Getr�nkeEuroAutomat extends EuroAutomat<Getr�nk> {

	@Override
	public Getr�nk frageNachProdukt() throws ProduktNotFoundException, ProduktAusverkauftException,
	        KaufAbgebrochenException {
		Getr�nk getr�nk = null;
		// Welches Getr�nk darf es bitte sein?
		// Alkoholisches Getr�nk? Bitte noch Ausweis zeigen.
		return getr�nk;
	}

	@Override
	public void gibWareAus(Getr�nk produkt) {
		// Schiebe das Produkt in die Ausgabe
	}

}
