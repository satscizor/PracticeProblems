package linkedlist.util;

public class Node {
//reference to next node	
public Node next;
//The actual data in the node
public Object data;

public Node(Object data)
{
	this.data = data;
}

public Object getData()
{
	return data;
}

public Node getNext() {
	return next;
}

public void setNext(Node next) {
	this.next = next;
}


}
