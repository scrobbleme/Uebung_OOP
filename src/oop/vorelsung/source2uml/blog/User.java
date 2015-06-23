package oop.vorelsung.source2uml.blog;

public class User implements Unique {
	Role role;
	String login;
	String password;
	String forname;
	String lastname;
	String uniqueId;

	public String getName() {
		return forname + " " + lastname;
	}

	public boolean isValidPassword(String password) {
		return password != null && password.equals(this.password);
	}

	@Override
	public String getID() {
		return uniqueId;
	}
}
