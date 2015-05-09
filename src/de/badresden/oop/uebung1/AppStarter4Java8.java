package de.badresden.oop.uebung1;

public class AppStarter4Java8 {

	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			System.err.println("Bitte mindestens ein Argument angeben.");
			return;
		}

		// This only works since Java 8
		System.out.println("Hello " + String.join(" ", args));
	}
}
