package de.badresden.oop.uebung1;

public class AppStarter2 {

	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			System.err.println("Bitte mindestens ein Argument angeben.");
			return;
		}
		String output = "Hello";
		for (String argument : args) {
			output = output + " " + argument;
		}
		System.out.println(output);
	}
}
