package oop.vorelsung.source2uml.blog.content;

import java.io.InputStream;

public class YouTubeVideoContent extends VideoContent {

	String youTubeId;
	boolean isPrivate;
	@Override
    public InputStream getVideoStream() {
	    return null;
    }
}
