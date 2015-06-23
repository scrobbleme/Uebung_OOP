package oop.vorlesung.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JoinExample4 extends JoinExample3 {

	public static void main(String[] args) throws InterruptedException {
		new JoinExample4().berechne();
	}

	public void berechne() throws InterruptedException {
		super.berechne();

		// Mit Threadpool und "Wrapper"
		{
			ExecutorService executor = Executors.newFixedThreadPool(10);
			long startTime = System.currentTimeMillis();
			// Threads erzeugen und sammeln.
			List<Double> ergebnis = new ArrayList<>();
			ergebnis.add(0.0);
			for (int i = 0; i < numbers.size(); i = i + JoinExample2.OFFSET) {
				final int currentIndex = i;
				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						Addierer addierer = new Addierer(numbers.subList(currentIndex, currentIndex
						        + JoinExample2.OFFSET));
						addierer.run();
						// Das funktioniert so leider nicht, da mehrere Threads
						// gleichzeitig drauf zugreifen könnten
						ergebnis.set(0, ergebnis.get(0) + addierer.getErgebnis());
					}
				};
				executor.execute(runnable);
			}
			executor.shutdown();
			executor.awaitTermination(1, TimeUnit.HOURS);
			System.out.println("Ergebnis (ohne Sync): " + ergebnis.get(0) + " in "
			        + (System.currentTimeMillis() - startTime) + " ms");
		}

	}
}
