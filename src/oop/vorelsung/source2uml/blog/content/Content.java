package oop.vorelsung.source2uml.blog.content;

import java.util.Date;

import oop.vorelsung.source2uml.blog.User;
import oop.vorelsung.source2uml.blog.Unique;

public abstract class Content implements Unique {
	String title;
	String uniqueId;
	Date date;
	User author;

	@Override
	public String getID() {
		return uniqueId;
	}

}
