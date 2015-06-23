package oop.vorlesung.serialisierung;

import java.io.Serializable;

public class Nutzer implements Serializable {

	private static final long serialVersionUID = 4260365594865745508L;

	private String login2;
	private String passwort = "123456";

	public Nutzer() {
	}

	public Nutzer(String login, String passwort) {
		this.login2 = login;
		this.passwort = passwort;
	}

	public String getLogin() {
		return login2;
	}

	public void setLogin(String login) {
		this.login2 = login;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

}