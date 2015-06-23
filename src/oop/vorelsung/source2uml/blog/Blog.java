package oop.vorelsung.source2uml.blog;

import java.util.List;

import oop.vorelsung.source2uml.blog.content.Content;

public class Blog {
	String title;
	String url;
	Content[] entries;
	User[] users;

	public List<Content> findEntries(String search) {
		return null;
	}

	public List<User> findUsers(Role role) {
		return null;
	}

	public String createContent(Content content) {
		return null;
	}

	public void deleteContent(String id) {
	}
}
