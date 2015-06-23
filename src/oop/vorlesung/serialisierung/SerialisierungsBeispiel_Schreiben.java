package oop.vorlesung.serialisierung;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialisierungsBeispiel_Schreiben {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Nutzer nutzer = new Nutzer("admin", "nimda");
		File file = new File("nutzer.txt");

		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
			outputStream.writeObject(nutzer);
		}
	}
}
