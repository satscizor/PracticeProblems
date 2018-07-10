package threads.thread;
/*
 * Find the sum of an array using 10 sequential threads
 */
public class ThreadJoinSequentialSum implements Runnable{
	static  int[] arr;
	private static int startIndex=0;
	private static volatile int partsum=0;
	
    public static void main(String[] args) {
	arr=new int[10000];
	for(int i=0;i<10000;i++) {
		arr[i]=i+1;
	}
	//Single thread
	System.out.println("Single threaded sum is ->"+findSum(arr));
	//Multiple concurrent threads
	System.out.println("Starting multi threaded process");
	try {
			Thread t1=new Thread(new ThreadJoinSequentialSum(),"t1");
			t1.start();
			t1.join();
			Thread t2=new Thread(new ThreadJoinSequentialSum(),"t2");
			t2.start();
			t2.join();
			Thread t3=new Thread(new ThreadJoinSequentialSum(),"t3");
			t3.start();
			t3.join();
			Thread t4=new Thread(new ThreadJoinSequentialSum(),"t4");
			t4.start();
			t4.join();
			Thread t5=new Thread(new ThreadJoinSequentialSum(),"t5");
			t5.start();
			t5.join();
			Thread t6=new Thread(new ThreadJoinSequentialSum(),"t6");
			t6.start();
			t6.join();
			Thread t7=new Thread(new ThreadJoinSequentialSum(),"t7");
			t7.start();
			t7.join();
			Thread t8=new Thread(new ThreadJoinSequentialSum(),"t8");
			t8.start();
			t8.join();
			Thread t9=new Thread(new ThreadJoinSequentialSum(),"t9");
			t9.start();
			t9.join();
			Thread t10=new Thread(new ThreadJoinSequentialSum(),"t10");
			t10.start();
			t10.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	System.out.println(partsum);
	
 }
//SingleThreadFindSum
private static int findSum(int[] arr) {
	int sum=0;
	for(int i=0;i<arr.length;i++) {
		sum+=arr[i];
	}
	return sum;
}
	@Override
	public void run() {
		System.out.println("Sum is being calculated by :"+Thread.currentThread().getName());
		System.out.println("["+Thread.currentThread().getName()+"] execution start | "+"Start index is "+startIndex);
		System.out.println("["+Thread.currentThread().getName()+"] execution start | "+"Sum till now is "+partsum);
		int sum=0;
		int endindex=startIndex+1000;
		for(int i=startIndex;i<endindex&&i<arr.length;i++) {
			sum+=arr[i];	
		}
		partsum+=sum;
		startIndex=startIndex+1000;
		System.out.println("["+Thread.currentThread().getName()+"] execution completed  | "+"Start index is "+startIndex);
		System.out.println("["+Thread.currentThread().getName()+"] execution start | "+"Sum till now is "+partsum);
	}
}
