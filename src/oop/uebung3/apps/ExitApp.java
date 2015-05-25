package oop.uebung3.apps;

public class ExitApp extends StreamableApp {

	public ExitApp() {
		super("exit", "Beendet das Programm.");
	}

	@Override
	public void process(String... args) {
		getOutputStream().println("Goodbye my friend.");
		System.exit(0);
	}

}
