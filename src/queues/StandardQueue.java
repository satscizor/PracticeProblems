package queues;

public class StandardQueue {

	static int front=-1;
	static int rear=-1;
	static final int size=10;
	static int [] queue=new int [size];
	
	public static void main(String[] args) {
		
		
		enQ(14);
		enQ(22);
		enQ(13);
		enQ(-6);
		deQ();
		deQ();
		enQ(9);
		enQ(20);
		enQ(5);
		
		System.out.println("The queue is ------>");
		for(int i=front;i<=rear;i++) {
			System.out.println(queue[i]);
		}
		
	}
	public static void enQ(int value) {
		  //Check either of the 2 conditions for queue to be full:
		  //[1] front is at 0 and rear has reached the end of the queue
		  //[2] rear is just behind front
		    if ((front == 0 && rear == size-1) ||
		            (rear == front-1))
		    {
		        System.out.println("Queue is Full");
		        return;
		    }
		    //First element insert to be done separately
		    else if (front == -1) 
		    {
		        front = rear = 0;
		        queue[rear] = value;
		    }
		    //If rear has reached the end of the circle queue and front is not at 0(i.e no value sitting at 0),reset rear to 0 and enter the value at 0th position.
		    else if (rear == size-1 && front != 0)
		    {
		        rear = 0;
		        queue[rear] = value;
		    }
		    //Normal enque
		    else
		    {
		        rear++;
		        queue[rear] = value;
		    }
	}
	public static void deQ() {
		if(front==-1) {
			System.out.println("QUEUE IS EMPTY!!!");
		}
		else {
			//Only one element
			if(front==rear)
				//set to -1 which will remove the pointer to that one element
				front=rear=-1;
			//front has reached the end of the queue,reset it to 0
			else if(front==size-1) {
				front=0;
			}
			else
				front++;
		}
	}
	
}
