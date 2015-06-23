package oop.vorlesung.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Quelle: http://openbook.rheinwerk-verlag.de/java7/1507_02_004.html
 */
public class DeadlockExample {

	private static Lock stift = new ReentrantLock();
	private static Lock papier = new ReentrantLock();

	static class T1 extends Thread {
		@Override
		public void run() {
			stift.lock();
			System.out.println("T1 hat Stift bekommen");

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
			}

			papier.lock();
			System.out.println("T1 hat Papier bekommen");

			papier.unlock();
			stift.unlock();
		}
	}

	static class T2 extends Thread {
		@Override
		public void run() {
			papier.lock();
			System.out.println("T2 hat Papier bekommen");

			stift.lock();
			System.out.println("T2 hat Stift bekommen");

			stift.unlock();
			papier.unlock();
		}
	}

	public static void main(String[] args) {
		new T1().start();
		new T2().start();
	}
}
