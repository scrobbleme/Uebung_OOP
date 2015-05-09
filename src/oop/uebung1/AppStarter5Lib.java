package oop.uebung1;

import org.apache.commons.lang3.StringUtils;

public class AppStarter5Lib {

	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			System.err.println("Bitte mindestens ein Argument angeben.");
			return;
		}

		// This uses the Apache Commons Lang library
		System.out.println("Hello " + StringUtils.join(args, " "));
	}
}
