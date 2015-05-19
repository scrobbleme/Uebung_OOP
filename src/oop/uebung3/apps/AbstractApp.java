package oop.uebung3.apps;

/**
 * Ein abstrakte Implementierung der App, welche bereits einige Vereinfachungen
 * vornimmt.
 */
public abstract class AbstractApp implements App {

	private final String description;
	private final String name;

	protected AbstractApp(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}
}
