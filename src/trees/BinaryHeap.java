package trees;



public class BinaryHeap
{
    private int[] heap;
    private int curreSize;
    private int maxsize;
 
    private static final int FRONT = 1;
 
    public BinaryHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.curreSize = 0;
        heap = new int[this.maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
    }
    
    /*
     * parent of a node is position/2
     * 
     */
    private int parent(int pos)
    {	
        return (int)Math.ceil((double)Math.max(0, pos-2)/2);
    }
    /*
     * parent of a node is position/2
     * 
     */
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
 
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 
    private boolean isLeaf(int pos)
    {
        if (pos >=  (curreSize / 2)  &&  pos <= curreSize)
        { 
            return true;
        }
        return false;
    }
 
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }
 
    private void minHeapify(int pos)
    {
        if (!isLeaf(pos))
        { 
            if ( heap[pos] > heap[leftChild(pos)]  || heap[pos] > heap[rightChild(pos)])
            {
                if (heap[leftChild(pos)] < heap[rightChild(pos)])
                {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }else
                {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
 
    public void insert(int element)
    {
        heap[++curreSize] = element;
        int current = curreSize;
 
        while (heap[current] < heap[parent(current)])
        {
            swap(current,parent(current));
            current = parent(current);
        }	
    }
 
    public void print()
    {
        for (int i = 1; i <= curreSize / 2; i++ )
        {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2*i] 
                + " RIGHT CHILD :" + heap[2 * i  + 1]);
            System.out.println();
        } 
    }
 
    public void minHeap()
    {
        for (int pos = (curreSize / 2); pos >= 1 ; pos--)
        {
            minHeapify(pos);
        }
    }
 
    public int remove()
    {
        int popped = heap[FRONT];
        heap[FRONT] = heap[curreSize--]; 
        minHeapify(FRONT);
        return popped;
    }
 
    public static void main(String...arg)
    {
        
        BinaryHeap minHeap = new BinaryHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        System.out.println("The Min Heap is ");
        minHeap.minHeap();
        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
    }
}