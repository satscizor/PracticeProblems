package stack;

import java.util.Stack;

public class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack(){
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min); //Could be negative if min value needs to change
            if (x < min) 
            	min = x;
        }
    }

    public int pop() {
        if (stack.isEmpty()) return -1;

        long pop = stack.pop();

        if (pop < 0) {
            long ret = min;
            min = min - pop; //If negative, increase the min value
            return (int)ret;
        }
        return (int)(pop + min);

    }

    public int top() {
        long top = stack.peek();
        if (top < 0) {
            return (int)min;
        } else {
           return (int)(top + min);
        }
    }

    public int getMin() {
        return (int)min;
    }
    
    public static void main(String[] args) {
		MinStack minstack=new MinStack();
		minstack.push(3);
		minstack.push(6);
		minstack.push(4);
		minstack.push(2);
		minstack.push(5);
		minstack.push(1);
		minstack.push(7);
		System.out.println("Top is :"+minstack.top());
		System.out.println("Current min is :"+minstack.getMin());
		System.out.println("Removing the top element---"+minstack.pop());
		System.out.println("Removing the top element---"+minstack.pop());
		System.out.println("Top is :"+minstack.top());
		System.out.println("Current min is :"+minstack.getMin());
	}
}
