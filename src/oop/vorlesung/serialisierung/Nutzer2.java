package oop.vorlesung.serialisierung;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Nutzer2 implements Serializable {

	private static final long serialVersionUID = 426036559486745508L;

	private String login;
	transient private String passwort = "123456";

	public Nutzer2() {
	}

	public Nutzer2(String login, String passwort) {
		this.login = login;
		this.passwort = passwort;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		// Nur Login schreiben
		oos.writeObject(login);
	}

	private void readObject(ObjectInputStream ois) throws IOException {
		try {
			ois.defaultReadObject();
			passwort = "Bitte ändern";
		} catch (ClassNotFoundException e) {
			throw new IOException("No class found. HELP!!");
		}
	}

}