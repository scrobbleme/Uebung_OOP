package oop.uebung3.apps;

/**
 * Die gemeinsame Schnittstelle für alle Apps.
 */
public interface App {

	/**
	 * @return Der Name und eindeutige Identifier der App.
	 */
	public String getName();

	/**
	 * @return Die Beschreibung der App.
	 */
	public String getDescription();

	/**
	 * Diese Methode führt die Logik der App aus.
	 * 
	 * @param args
	 *            Alle Parameter der Kommandozeile.
	 */
	public void process(String[] args);

}
