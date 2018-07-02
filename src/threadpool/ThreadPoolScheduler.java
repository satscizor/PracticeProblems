package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadPoolScheduler {

	//You will need a blocking queue for the tasks(which is basically integer here)
	private BlockingQueue<Integer> tasks;
	//Now lets initialize the threadpool
	private List<PoolThread> threadpool=new ArrayList<PoolThread>();
	private boolean isStopped;
	
	public ThreadPoolScheduler(int numberOfThreads,int numberOfTasks) {
		//Add the threads
		for(int i=0;i<numberOfThreads;i++) {
			threadpool.add(new PoolThread(tasks));
		}
		//start all the threads after adding
		for(PoolThread thread:threadpool)
			new Thread(thread).start();
	 }
	
	public synchronized void execute() {
		if(isStopped)
			throw new IllegalStateException("Server is stopped,cannot execute!!!");
		
		try {
			Random r=new Random();
			Integer task=r.nextInt();
			System.out.println("Putting this task to the queue:"+task);
			this.tasks.put(task);			
		}
		catch(InterruptedException ex) {
			Logger.getLogger(ThreadPoolScheduler.class.getName()).log(Level.SEVERE, "Interruption has come", ex);;
		}
	}
	
	public synchronized void stop() {
		this.isStopped=true;
		for(PoolThread thread:threadpool) {
			thread.stopThread();
		}
	}
	
}
