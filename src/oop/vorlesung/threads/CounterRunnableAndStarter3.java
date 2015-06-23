package oop.vorlesung.threads;

/**
 * Die Threads bekommen einen Namen.
 */
public class CounterRunnableAndStarter3 {

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable1 = new Counter();
		Thread thread1 = new Thread(runnable1, "A");
		thread1.start();

		Runnable runnable2 = new Counter();
		Thread thread2 = new Thread(runnable2, "\tB");
		thread2.start();
	}
}
