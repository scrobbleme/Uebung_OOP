package oop.vorlesung.threads;

/**
 * Ein einfacher Thread.
 */
public class CounterRunnableAndStarter1 {

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new Counter();
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
		Thread.sleep(1000);

	}
}