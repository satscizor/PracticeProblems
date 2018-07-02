package linkedlist;

import linkedlist.util.Node;

public class SinglyLinkedList {
	private static Node head;
	private static int numNodes;
	
	//constructor to create the head node on start up
	public SinglyLinkedList(Object data)
	{
		head = new Node(data);
	}
	
	public static void main(String[] args) {
		SinglyLinkedList list=new SinglyLinkedList(1);
		for(int i=1;i<10;i++) {
			list.addAtIndex(i, i+1);
		}
		System.out.println("The list is :");
		list.printList(head);
		System.out.println("The middle element is :"+list.findMiddleElelment(head).getData());
		System.out.println("Printing reverse is :");
		list.printListInReverse(head);
		System.out.println();
		System.out.println("Reversing the linked list : ");
		head=ReverseLinkedList.Reverse(head);
		System.out.println("The list is now :");
		list.printList(head);
	}
	
	/*
	 * Add the new node to the head 
	 *
	 */
	public void addAtHead(Object data) {
		Node temp = head;
		head = new Node(data);
		head.setNext(temp); 
		numNodes++;	
	}
	
	/*
	 * Add the new node to the tail.
	 * Iterate through the nodes till the end i.e when next is null.
	 * Add a new next node at the tail and increment the node count.
	 *
	 */
	public void addAtTail(Object data)
	{
		Node temp = head;
		while(temp.getNext() != null)
		{
			temp = temp.getNext();
		}	
		temp.setNext(new Node(data));
		numNodes++;
	}
	
	/*
	 * Pass the index at which the nodes needs to be added and the data to be added.
	 * 
	 * Iterate to the element just before the index(index-1)
	 * and set the temp node.
	 * 
	 * Holder is the node to store the node which was at that position which will be moved one place 
	 */
	public void addAtIndex(int index, Object data)
	{
		Node temp = head;
		Node holder;
		for(int i=0; i < index-1 && temp.getNext() != null; i++)
		{
			temp = temp.getNext();
		}
		//holder stores the node to be displaced
		holder = temp.getNext();
		//create a new node in place of the holder
		temp.setNext(new Node(data));
		//Add holder as next to that new node
		temp.getNext().setNext(holder);
		//increment the node count
		numNodes++;
	}
	/*
	 * Delete the node at particular index
	 * 
	 * Iterate to the node before the index
	 * set the next of that node to the node after the index
	 * the node without reference will be garbage collected.
	 * 
	 */
	public void deleteAtIndex(int index)
	{
		Node temp = head;
		for(int i=0; i< index - 1 && temp.getNext() != null; i++)
		{
			temp = temp.getNext();
		}
		temp.setNext(temp.getNext().getNext());
		numNodes--;
	}
	
	public static int find(Node n)
	{
		Node t = head;
		int index = 0;
		while(t != n)
		{
			index++;
			t = t.getNext();
		}
		return index;
	}
	
	public static Node find(int index)
	{
		Node temp=head;
		for(int i=0; i<index; i++)
		{
			temp = temp.getNext();
		}
		return temp;
	}
		
	public void printList(Node head)
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.getData()+"--->");
			temp = temp.getNext();
		}
	}
	
	public void printListInReverse(Node head)
	{
		if(head!=null) {
			printListInReverse(head.getNext());
			System.out.print("<---"+head.getData());
		}
	}
	
	
	public static int getSize()
	{
		return numNodes;
	}
	
	public Node findMiddleElelment(Node head) {
		System.out.println();
		Node first=head;
		if(first.getNext().getNext()==null)
			return first;
		while(head.getNext()!=null) {
			first=first.getNext().getNext();
			head=head.getNext();
			if(first.getNext()==null||first.getNext().getNext()==null) {
				break;
			}
		}
		return head;		
	}
	
}
