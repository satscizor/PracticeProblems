package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Here is a simple example of CyclicBarrier in Java on which we initialize CyclicBarrier with 3 parties, means in order to cross barrier, 3 thread needs to call await() method. 
 * Each thread calls await method in short duration but they don't proceed until all 3 threads reached the barrier, once all thread reach the barrier, barrier gets broker and each thread started their execution from that point. 
 */
public class CyclicBarrierDemo {

	// Runnable task for each thread
	private static class Task implements Runnable {

		private CyclicBarrier barrier;

		public Task(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
				//Only proceed once all the threads crosses the barrier
				barrier.await();
				System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
			} catch (InterruptedException ex) {
				Logger.getLogger(CyclicBarrierDemo.class.getName()).log(Level.SEVERE, null, ex);
			} catch (BrokenBarrierException ex) {
				Logger.getLogger(CyclicBarrierDemo.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public static void main(String args[]) {

		// creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()
		// Need to give a barrier action  which is a task executed once all the concerned threads reaches the barrier
		final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				// This task will be executed once all thread reaches barrier
				System.out.println("All parties are arrived at barrier, lets play");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Game played,now let the other parties cross the barrier");
			}
		});

		// starting each of thread
		Thread t1 = new Thread(new Task(cb), "Thread 1");
		Thread t2 = new Thread(new Task(cb), "Thread 2");
		Thread t3 = new Thread(new Task(cb), "Thread 3");

		t1.start();
		t2.start();
		t3.start();

	}
}
