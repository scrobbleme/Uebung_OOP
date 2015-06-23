package oop.vorlesung.threads;

/**
 * Der Daemon-Thread wird sofort beendet, wenn das Programm zu Ende ist.
 */
public class DaemonCounterRunnableAndStarter1 {

	public static void main(String[] args) {
		Runnable runnable = new Counter();
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
	}
}