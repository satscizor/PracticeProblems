package threads.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFutureTask {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	
    	System.out.println("<--------------------USING CALLABLE----------------->");
    	// FutureTask is a concrete class that
        // implements both Runnable and Future
    	FutureTask<Double>[] randomtasks=new FutureTask[5];
    	
    	 for (int i = 0; i < 5; i++)
    	    {
    	      Callable<Double> callable = new MyCallable(); 
    	      // Create the FutureTask with Callable
    	      randomtasks[i] = new FutureTask<Double>(callable); 
    	      // As it implements Runnable, create Thread
    	      // with FutureTask
    	      Thread t = new Thread(randomtasks[i]);
    	      t.start();
    	    }
    	 
    	 for (int i = 0; i < 5; i++)
    	    {
    	      // As it implements Future, we can call get()
    	      System.out.println(randomtasks[i].get());
    	 
    	      // This method blocks till the result is obtained
    	      // The get method can throw checked exceptions
    	      // like when it is interrupted. This is the reason
    	      // for adding the throws clause to main
    	    }
    	 
    	 System.out.println("<--------------------USING RUNNABLE DOING THE SAME----------------->");
    	 
    	 MyRunnable[] mythreads=new MyRunnable[5];
    	 //Intialize 5 threads and just start them
    	 for(int i=0;i<5;i++) {
    		 mythreads[i]=new MyRunnable();
    		 Thread t=new Thread(mythreads[i],"t"+(i+1));
    		 t.start();
    	 }
    	 
    	 for (int i = 0; i < 5; i++)
 	    {
 	      System.out.println(mythreads[i].get());
 	    }
	}
}




class MyCallable implements Callable<Double>{
	@Override
	public Double call() throws Exception {
		String tname=Thread.currentThread().getName();
		System.out.println(tname+" My callable task");
		System.out.println(tname+" I am sleeping for 5 seconds");
		Thread.sleep(5000);
		System.out.println(tname+ " I woke up");
		System.out.println(tname+" returning some Random value");
		return Math.random();
	}
}


class MyRunnable implements Runnable{
	
	private Object result = null;
		@Override
		public void run() {
			String tname=Thread.currentThread().getName();
			System.out.println(tname+" My callable task");
			System.out.println(tname+" I am sleeping for 5 seconds");
			//As run cannot throw exception
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(tname+ " I woke up");
			System.out.println(tname+" returning some Random value");		
			result=Math.random();	
			 // Wake up threads blocked on the get() method
	        synchronized(this)
	        {
	            notifyAll();
	        }
		}
		public synchronized Object get() throws InterruptedException {
			 while (result == null)
		            wait();
		        return result;
		}	
	}