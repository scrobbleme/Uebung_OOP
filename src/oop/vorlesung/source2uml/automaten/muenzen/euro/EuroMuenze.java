package oop.vorlesung.source2uml.automaten.muenzen.euro;

import oop.vorlesung.source2uml.automaten.muenzen.AbstrakteMuenze;

public abstract class EuroMuenze extends AbstrakteMuenze {

	protected EuroMuenze(int wert) {
		super("EURO", wert);
	}
}
