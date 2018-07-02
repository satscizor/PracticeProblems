package linkedlist;

import linkedlist.util.Node;

public class ReverseLinkedList {

	/*	ALGORITHM
	 * 
    1) Divide the list in two parts - first node and rest of the linked list.
	2) Call reverse for the rest of the linked list.
	3) Link rest to first.
	4) Fix head pointer
	*
	*/
	
	static Node Reverse(Node head) {
	    //Exit condition in recursion
	    if(head==null||head.getNext()==null){
	        //return head when it is at the 1st element(back to front recursion)
	       return head; 
	    }
	    else{
	        //Go to the last node
	        Node left=Reverse(head.getNext());
	        //Reverse from last node
	        head.getNext().setNext(head);
	        //set the new tail next to null
	        head.setNext(null);
	        //return the left part
	        return left;
	        
	    }
   }
}
