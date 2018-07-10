package threads.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableExecutorService {
	public static void main(String[] args) {
      //Get ExecutorService from Executors utility class, thread pool size is 10
      ExecutorService executor = Executors.newFixedThreadPool(10);
      
      //create a list to hold the Future object associated with Callable
      List<Future<String>> list = new ArrayList<Future<String>>();
      
      //Create MyCallable instance
      Callable<String> callable = new SampleThread();
      
      for(int i=0; i< 100; i++){
          //submit Callable tasks to be executed by thread pool
          Future<String> future = executor.submit(callable);
          //add Future to the list, we can get return value using Future
          list.add(future);
      }
      
      for(Future<String> future : list){
          try {
              //print the return value of Future, notice the output delay in console
              // because Future.get() waits for task to get completed
              System.out.println(new Date()+ "::"+future.get());
          } catch (InterruptedException | ExecutionException e) {
              e.printStackTrace();
          }
      }
      //shut down the executor service now in prescribed manner
      executor.shutdown();
      try {
          if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
        	  executor.shutdownNow();
          } 
      } catch (InterruptedException e) {
    	  executor.shutdownNow();
      }
      
      
	}
}

class SampleThread  implements Callable<String>{

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return Thread.currentThread().getName();
	}
}
