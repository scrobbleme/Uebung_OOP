package de.badresden.oop.uebung1;

public class AppStarter3 {

	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			System.err.println("Bitte mindestens ein Argument angeben.");
			return;
		}
		System.out.print("Hello");
		for (String argument : args) {
			System.out.print(" " + argument);
		}
	}
}
