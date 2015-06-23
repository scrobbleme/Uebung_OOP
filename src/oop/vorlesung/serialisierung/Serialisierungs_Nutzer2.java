package oop.vorlesung.serialisierung;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialisierungs_Nutzer2 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Nutzer2 nutzer = new Nutzer2("admin", "nimda");
		File file = new File("nutzer2.txt");

		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {

			outputStream.writeObject(nutzer);
		}

		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {

			nutzer = (Nutzer2) inputStream.readObject();
			System.out.println("Login: " + nutzer.getLogin());
			System.out.println("Passwort: " + nutzer.getPasswort());

		}
	}
}
