package oop.vorlesung.serialisierung;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerialisierungsBeispiel_Lesen {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("nutzer.txt");
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {

			Nutzer nutzer = (Nutzer) inputStream.readObject();
			System.out.println("Login: " + nutzer.getLogin());
			System.out.println("Passwort: " + nutzer.getPasswort());

		}
	}
}
