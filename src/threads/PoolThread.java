package threads;

import java.util.concurrent.BlockingQueue;

public class PoolThread implements Runnable {
	private BlockingQueue<Integer> tasks;
	private boolean isStopped=false;

	public PoolThread(BlockingQueue<Integer> tasks) {
		this.tasks=tasks;
	}

	@Override
	public void run() {
			while(!isStopped) {
				try {
					System.out.println("Removed this taks from the queue"+this.tasks.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}

	public void stopThread() {
		isStopped=true;
		new Thread(this).interrupt();	
	}

}
