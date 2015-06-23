package oop.vorlesung.uml2code;

public class Ritual extends Termin {
	private Handlung[] handlungen;

	public String name;
	public String anlass;
	public Person[] teilnehmer;

	public Handlung[] getHandlungen() {
		return handlungen;
	}

	public void setHandlungen(Handlung[] handlungen) {
		this.handlungen = handlungen;
	}

}
