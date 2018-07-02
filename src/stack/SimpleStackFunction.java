package stack;

public class SimpleStackFunction {
	static int stackSize=10;
	static int stack[] = new int [stackSize];	
	static int top=-1;
	
	public static void main(String[] args) {	
		push(10);
		push(20);
		push(50);
		pop();
		push(80);
		push(130);
		pop();
		pop();
		System.out.println("The stack is --------------------");
		for(int i=0;i<=top;i++) {
			System.out.println("["+stack[i]+"]");
		}
	}
	
	public static void push(int number) {
		if(top==stackSize-1) {
			System.out.println("Stack is full");
		}
		else {
			stack[++top]=number;
		}
	}
	public static void pop() {
		if(top==-1) {
			System.out.println("Stack is empty");
		}
		else {
			top--;
		}
	}
}
