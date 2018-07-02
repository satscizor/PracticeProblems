package trees;

public class Heap {
	//data array
	int arr [];
	//head number of elements
	int count;
	//size of the heap
	int capacity;
	//max or min_heap
	int heapType;
	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getHeapType() {
		return heapType;
	}
	public void setHeapType(int heapType) {
		this.heapType = heapType;
	}
	
	
}
