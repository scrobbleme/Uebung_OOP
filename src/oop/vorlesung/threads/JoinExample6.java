package oop.vorlesung.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class JoinExample6 extends JoinExample5 {

	public static void main(String[] args) throws InterruptedException {
		new JoinExample6().berechne();
	}

	public void berechne() throws InterruptedException {
		super.berechne();

		// Mit Threadpool und AtomicInteger
		ExecutorService executor = Executors.newFixedThreadPool(10);
		long startTime = System.currentTimeMillis();

		AtomicLong ergebnis = new AtomicLong(0);
		for (int i = 0; i < numbers.size(); i = i + JoinExample2.OFFSET) {
			final int currentIndex = i;

			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					Addierer addierer = new Addierer(numbers.subList(currentIndex, currentIndex + JoinExample2.OFFSET));
					addierer.run();
					ergebnis.addAndGet(addierer.getErgebnis());
				}
			};

			executor.execute(runnable);
		}
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.HOURS);
		System.out.println("Ergebnis (mit AtomicInteger): " + ergebnis.get() + " in "
		        + (System.currentTimeMillis() - startTime) + " ms");
	}
}
