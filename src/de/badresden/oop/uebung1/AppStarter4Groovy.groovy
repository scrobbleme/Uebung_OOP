package de.badresden.oop.uebung1;

if (args == null || args.length == 0) {
	System.err.println("Bitte mindestens ein Argument angeben.");
	return;
}

print "Hello " + args.join(" ");
