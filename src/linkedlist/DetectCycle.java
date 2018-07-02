package linkedlist;

import linkedlist.util.Node;

public class DetectCycle {

	public static boolean detectCycleInLinkedList(Node head) {
	    if(head==null||head.next==null)
	         return false;
	     Node slow=head;
	     Node fast=head;
	     while(fast!=null&&slow!=null){
	         if(slow.next==null)
	             return false;
	         if(fast.next==null||fast.next.next==null)
	             return false;
	         if(slow.next==fast.next.next) return true;
	         slow=slow.next;
	         fast=fast.next.next;
	     }
	        return false;
	}
}
