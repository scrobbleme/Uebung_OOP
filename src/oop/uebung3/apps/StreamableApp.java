package oop.uebung3.apps;

import java.io.PrintStream;

/**
 * Die StreamableApp erlaubt es den Ausgabestrom umzuleiten.
 */
public abstract class StreamableApp extends AbstractApp {

	private PrintStream outputStream;

	protected StreamableApp(String name, String description) {
		this(name, description, System.out);
	}

	protected StreamableApp(String name, String description, PrintStream outputStream) {
		super(name, description);
		this.setOutputStream(outputStream);
	}

	public PrintStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(PrintStream outputStream) {
		this.outputStream = outputStream;
	}
}
