package oop.uebung2.aufgabe4.apps;

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
