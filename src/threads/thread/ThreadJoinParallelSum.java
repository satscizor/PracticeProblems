package threads.thread;

public class ThreadJoinParallelSum extends Thread{
    private int[] arr;

    private int low, high, partial;

    public ThreadJoinParallelSum(int[] arr, int low, int high)
    {
        this.arr = arr;
        this.low = low;
        this.high = Math.min(high, arr.length);
    }

    public int getPartialSum()
    {
        return partial;
    }

    public void run()
    {
        partial = sum(arr, low, high);
    }

    public static int sum(int[] arr)
    {
        return sum(arr, 0, arr.length);
    }

    public static int sum(int[] arr, int low, int high)
    {
        int total = 0;

        for (int i = low; i < high; i++) {
            total += arr[i];
        }

        return total;
    }

    public static int parallelSum(int[] arr)
    {
        return parallelSum(arr, Runtime.getRuntime().availableProcessors());
    }

    public static int parallelSum(int[] arr, int threads)
    {
        int size = (int) Math.ceil(arr.length * 1.0 / threads);

        ThreadJoinParallelSum[] sums = new ThreadJoinParallelSum[threads];

        for (int i = 0; i < threads; i++) {
            sums[i] = new ThreadJoinParallelSum(arr, i * size, (i + 1) * size);
            sums[i].start();
        }

        try {
            for (ThreadJoinParallelSum sum : sums) {
                sum.join();
            }
        } catch (InterruptedException e) { }

        int total = 0;

        for (ThreadJoinParallelSum sum : sums) {
            total += sum.getPartialSum();
        }

        return total;
    }
    
    public static void main(String[] args) {
    	int arr[]=new int[1000000];
    	for(int i=0;i<arr.length;i++) {
    		arr[i]=i+1;
    	}
    	 long start = System.currentTimeMillis();
    	 System.out.println(ThreadJoinParallelSum.sum(arr));
    	 System.out.println("Single: " + (System.currentTimeMillis() - start)); // Single

    	 start = System.currentTimeMillis();
    	 System.out.println(ThreadJoinParallelSum.parallelSum(arr));
    	 System.out.println("Parallel: " + (System.currentTimeMillis() - start)); // Parallel		 
	}
}
