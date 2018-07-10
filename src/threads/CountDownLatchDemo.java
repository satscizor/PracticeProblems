package threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.CountDownLatch;

/*
 * Demonstrate an use of Countdownlatch in java
 * --------------------------------------------
 * Definition of a CoundownLatch
 * 
 * 	A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes. 
	A CountDownLatch is initialized with a given count. The await methods block until the current count reaches zero due to invocations of the countDown method, after which all waiting threads are released and any subsequent invocations of await return immediately.
	This is a one-shot phenomenon -- the count cannot be reset.
    If you need a version that resets the count, consider using a CyclicBarrier. 
	A CountDownLatch is a versatile synchronization tool and can be used for a number of purposes. A CountDownLatch initialized with a count of one serves as a simple on/off latch, or gate:
	all threads invoking await wait at the gate until it is opened by a thread invoking countDown. A CountDownLatch initialized to N can be used to make one thread wait until N threads have completed some action, or some action has been completed N times. 
	A useful property of a CountDownLatch is that it doesn't require that threads calling countDown wait for the count to reach zero before proceeding, it simply prevents any thread from proceeding past an await until all threads could pass. 
*/
public class CountDownLatchDemo {
	public static void main(String args[]) {
	       final CountDownLatch latch = new CountDownLatch(3);
	       Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
	       Thread alertService = new Thread(new Service("AlertService", 1000, latch));
	       Thread validationService = new Thread(new Service("ValidationService", 1000, latch));
	      
	       cacheService.start(); //separate thread will initialize CacheService
	       alertService.start(); //another thread for AlertService initialization
	       validationService.start();
	      
	       // application should not start processing any thread until all service is up
	       // and ready to do there job.
	       // Countdown latch is idle choice here, main thread will start with count 3
	       // and wait until count reaches zero. each thread once up and read will do
	       // a count down. this will ensure that main thread is not started processing
	       // until all services is up.
	      
	       //count is 3 since we have 3 Threads (Services)
	      
	       try{
	            latch.await();  //main thread is waiting on CountDownLatch to finish
	            System.out.println("All services are up, Application is starting now");
	       }catch(InterruptedException ie){
	           ie.printStackTrace();
	       }
	      
	    }
}

class Service implements Runnable {
	private final String name;
	private final int timeToStart;
	private final CountDownLatch latch;

	public Service(String name, int timeToStart, CountDownLatch latch) {
		this.name = name;
		this.timeToStart = timeToStart;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToStart);
		} catch (InterruptedException ex) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(name + " is Up");
		latch.countDown(); // reduce count of CountDownLatch by 1
	}

}