package threads;

import java.util.concurrent.Semaphore;

/*
 * A Counting semaphore with one permit is known as binary semaphore because it has only two state permit available or permit unavailable.
 * Binary semaphore can be used to implement mutual exclusion or critical section where only one thread is allowed to execute. 
 * Thread will wait on acquire() until Thread inside critical section release permit by calling release() on semaphore.
 * 
 */
public class CountingBinarySemaphore {
	//binary semaphore has only 1 permit
	Semaphore binary = new Semaphore(1);

	public static void main(String args[]) {
		final CountingBinarySemaphore test = new CountingBinarySemaphore();
		//Thread 0
		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();
		//Thread 1
		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();

	}

	private void mutualExclusion() {
		try {
			// Acquires a permit from this semaphore, blocking until one is available, or
			// the thread is interrupted.
			// Acquires a permit, if one is available and returns immediately, reducing the
			// number of available permits by one.
			binary.acquire();
			// mutual exclusive region
			System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			binary.release();
			System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
		}
	}
}
