package threads.thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

	class Producer implements Runnable {
	   private final BlockingQueue<Integer> queue;
	   int count;
	   Producer(BlockingQueue<Integer> q,int count) { 
		   		queue = q; 
		   		this.count=count;
		   }
	   public void run() {
	     try {
	       while (count>0) { 
	    	   queue.put(produce());
	    	   System.out.println("The queue is :"+queue);
	    	   count--;
	    	 }
	     } catch (InterruptedException ex) { 
	    	 System.out.println("Interruption in thread");
	     }
	   }
	   Integer produce() { 
		   Random r=new Random();
		   Integer next=r.nextInt();
		   System.out.println("Putting this number into the queue : "+next);
		   return next;
	   }
	 }

	 class Consumer implements Runnable {
	   private final BlockingQueue<Integer> queue;
	   int count;
	   Consumer(BlockingQueue<Integer> q,int count) { 
		   queue = q; 
		   this.count=count;
		   }
	   public void run() {
	     try {
	       while (count>0) { 
	    	   consume(queue.take());
	    	   count--;
	    	}
	     } catch (InterruptedException ex) { 
	    	 System.out.println("Interruption in thread");}
	   }
	   void consume(Object x) { 
		   System.out.println("C["+Thread.currentThread().getName()+"]Consumes the head of the queue :"+x);
	   }
	 }

	 public class ProducerConsumer {
	   public static void main(String args[]) {
	     BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
	     Producer p = new Producer(q,5);
	     Consumer c1 = new Consumer(q,5);
	     Consumer c2 = new Consumer(q,5);
	     new Thread(p).start();
	     new Thread(c1).start();
	     new Thread(c2).start();   
	 }
}