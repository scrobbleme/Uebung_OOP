package oop.vorlesung.threads;

import java.util.List;

public class JoinExample {

	public static void main(String[] args) throws InterruptedException {
		// Ohne Join:
		Addierer addierer = new Addierer(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Thread thread = new Thread(addierer);
		thread.start();
		System.out.println("Ergebnis ohne join: " + addierer.getErgebnis());

		// Mit Join:
		Addierer addierer2 = new Addierer(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Thread thread2 = new Thread(addierer2);
		thread2.start();
		thread2.join();
		System.out.println("Ergebnis mit join: " + addierer2.getErgebnis());
	}
}

class Addierer implements Runnable {

	private long[] werte;
	private Long ergebnis = null;

	public Addierer(long... werte) {
		this.werte = werte;
	}

	public Addierer(List<Long> numbers) {
		werte = new long[numbers.size()];
		for (int i = 0; i < numbers.size(); i++) {
			werte[i] = numbers.get(i);
		}
	}

	@Override
	public void run() {
		ergebnis = 0L;
		for (long wert : werte) {
			ergebnis += wert;
			try {
				// Diese Berechnung ist aufwändig und braucht deshalb viel Zeit
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Long getErgebnis() {
		return ergebnis;
	}
}
