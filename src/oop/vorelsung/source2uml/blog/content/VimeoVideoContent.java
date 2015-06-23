package oop.vorelsung.source2uml.blog.content;

import java.io.InputStream;

public class VimeoVideoContent extends VideoContent {
	String vimeoId;

	@Override
    public InputStream getVideoStream() {
	    return null;
    }
}
