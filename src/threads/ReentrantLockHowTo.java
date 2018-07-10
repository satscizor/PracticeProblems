package threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHowTo {

	static class ThreadTest implements Runnable {

		private final ReentrantLock lock = new ReentrantLock();
		private int count = 0;

		public void run() {
			while (true) {
				try {
					getCount();
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}

		// Locking using Lock and ReentrantLock
		public int getCount() {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
				return count++;
			} finally {
				lock.unlock();
			}
		}

		// Implicit locking using synchronized keyword
		public synchronized int getCountTwo() {
			return count++;
		}

		public static void main(String args[]) {
			final ThreadTest threadCounter = new ThreadTest();
			Thread t1 = new Thread() {
				@Override
				public void run() {
					while (threadCounter.getCount() < 6) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}
				}
			};

			Thread t2 = new Thread() {
				@Override
				public void run() {
					while (threadCounter.getCount() < 6) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}
				}
			};

			t1.start();
			t2.start();

		}

	}
}