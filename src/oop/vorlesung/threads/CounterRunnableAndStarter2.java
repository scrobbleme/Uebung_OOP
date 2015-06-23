package oop.vorlesung.threads;

public class CounterRunnableAndStarter2 {

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable1 = new Counter();
		Thread thread1 = new Thread(runnable1);
		thread1.start();

		Runnable runnable2 = new Counter();
		Thread thread2 = new Thread(runnable2);
		thread2.start();
	}
}
