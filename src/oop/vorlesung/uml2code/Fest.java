package oop.vorlesung.uml2code;

public class Fest extends Termin {

	public String name;
	public String anlass;
	public Ritual[] rituale;

	public void feiere() {
		for (Ritual ritual : rituale) {
			führeRitualAus(ritual);
		}
	}

	private void führeRitualAus(Ritual ritual) {
	}
}
