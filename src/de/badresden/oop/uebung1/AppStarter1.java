package de.badresden.oop.uebung1;


public class AppStarter1 {

	public static void main(String[] args) {
		main(null);
		// 1. Prüfe Anzahl Elemente -> wenn weniger 1 -> Fehler (if)
		if(args == null || args.length == 0){
			// Ausgabe
			return;
		}else{
			
		}
		
		// 2. Gib Parameter hintereinander aus (z.B. for-Schleife)
		
		for(int i =0 ; i< args.length; i++){
			String argument = args[i];
			
		}
		
		for(String argument: args){
			
		}
		
		System.out.println("Hello World");
	}
}
