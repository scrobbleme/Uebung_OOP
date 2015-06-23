package oop.vorlesung.threads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class JoinExample2 {

	public final static int OFFSET = 10;
	public final static int NUMBERS_TO_GENERATE = OFFSET * 100;

	protected List<Long> numbers = new ArrayList<>();

	{

		// Ganz viele Zufallszahlen
		for (int i = 0; i < NUMBERS_TO_GENERATE; i++) {
			numbers.add(Math.round(Math.random() * 100));
		}

	}

	public static void main(String[] args) throws InterruptedException {
		new JoinExample2().berechne();
	}

	public void berechne() throws InterruptedException {
		// Ohne Threads
		long startTime = System.currentTimeMillis();
		Addierer summer = new Addierer(numbers);
		summer.run();
		System.out.println("Ergebnis (ohne Threads): " + summer.getErgebnis() + " in "
		        + (System.currentTimeMillis() - startTime) + " ms");

		// Mit Threads
		startTime = System.currentTimeMillis();
		Map<Thread, Addierer> threads = new HashMap<Thread, Addierer>();
		// Threads erzeugen und sammeln.
		for (int i = 0; i < numbers.size(); i = i + OFFSET) {
			Addierer addierer = new Addierer(numbers.subList(i, i + OFFSET));
			Thread thread = new Thread(addierer);
			thread.start();
			threads.put(thread, addierer);
		}
		long ergebnis = 0;
		// Threads joinen und Gesamtergebnis berechnen.
		for (Entry<Thread, Addierer> entry : threads.entrySet()) {
			entry.getKey().join();
			ergebnis += entry.getValue().getErgebnis();
		}
		System.out.println("Ergebnis (mit Threads): " + ergebnis + " in " + (System.currentTimeMillis() - startTime)
		        + " ms");
	}
}
