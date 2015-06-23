package oop.vorelsung.source2uml.blog.content;

import java.io.InputStream;

public abstract class VideoContent extends Content {
	String videoUrl;

	public abstract InputStream getVideoStream();

}
