package oop.vorlesung.threads;

public class Counter implements Runnable {

	@Override
	public void run() {
		for (int i = 1;; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}