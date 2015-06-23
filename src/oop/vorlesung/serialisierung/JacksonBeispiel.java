package oop.vorlesung.serialisierung;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonBeispiel {
	public static void main(String[] args) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Nutzer nutzer = new Nutzer("admin", "nimda");

		String nutzerAsString = objectMapper.writeValueAsString(nutzer);

		System.out.println("Als JSON: " + nutzerAsString);

		Nutzer nutzer2 = objectMapper.readValue(nutzerAsString, Nutzer.class);
		System.out.println("\nWieder eingelesen: " + nutzer2.getLogin() + " " + nutzer2.getPasswort());
	}
}
