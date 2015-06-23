package oop.vorlesung.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JoinExample3 extends JoinExample2 {

	public static void main(String[] args) throws InterruptedException {
		new JoinExample3().berechne();
	}

	@Override
	public void berechne() throws InterruptedException {
		super.berechne();

		// Mit Threadpool
		ExecutorService executor = Executors.newFixedThreadPool(10);
		long startTime = System.currentTimeMillis();
		List<Addierer> addierers = new ArrayList<>();
		// Threads erzeugen und sammeln.
		for (int i = 0; i < numbers.size(); i = i + JoinExample2.OFFSET) {
			Addierer addierer = new Addierer(numbers.subList(i, i + JoinExample2.OFFSET));
			addierers.add(addierer);
			executor.execute(addierer);
		}
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.HOURS);
		long ergebnis = 0;
		for (Addierer addierer : addierers) {
			ergebnis += addierer.getErgebnis();
		}
		System.out.println("Ergebnis (mit Threadpool): " + ergebnis + " in " + (System.currentTimeMillis() - startTime)
		        + " ms");
	}
}
