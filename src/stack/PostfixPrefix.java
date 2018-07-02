package stack;

import java.util.Scanner;

public class PostfixPrefix {


public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the expression");
		String expression=sc.nextLine();
		StringBuilder sb=new StringBuilder();
		char [] stack=new char [sb.length()];
		int top=-1;
		char [] expList=expression.toCharArray();
		for(int i=0;i<expList.length;i++) {
			if(Character.isLetter(expList[i])) {
				sb.append(expList[i]);
			}
			else if(expList[i]=='}'||expList[i]==']'||expList[i]==')') {
				patternMatch(top,stack, i,sb);
			}	
			else
			{
				//TODO
				push(stack, top, expList[i]);
			}
		}			
    }

private static void patternMatch(int top, char[] stack, int i, StringBuilder sb) {
	for(int j=i-1;j>=0;j--) {
		pop(stack,top,sb);
		if(stack[j]=='{'||stack[j]=='['||stack[j]=='(') {
			pop(stack,top,sb);
			break;
		}
	}
}

private static void pop(char[] expList, int top, StringBuilder sb) {
	if(top==-1)
		System.out.println("Stack is empty,cannot pop");
	else
		sb.append(expList[top]);
	    top--;
	}

private static void push(char[] stack, int top,char value) {
	if(top==stack.length-1)
		System.out.println("Stack is full");
	else
		stack[++top]=value;
	}
}
