package trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopView {
	
	public static Map<Integer,List<Integer>> hdMap=new TreeMap<Integer ,List<Integer>>();
	public static ArrayList<Integer> levelOrder=new ArrayList<Integer>();
	
 public static void main(String[] args) {

		SimpleTraversal sp=new SimpleTraversal();
		 sp.add(6);
		 sp.add(4);
		 sp.add(8);
		 sp.add(3);
		 sp.add(5);
		 sp.add(7);
		 sp.add(9);
		 getHdMap(sp.getRoot(),0);
		 levelOrder(sp.getRoot());
		 printTopView();
 		}
 
 
 private static void printTopView() {
	Set<Integer> set=hdMap.keySet();
	for(Integer i:set) {
		List<Integer> list=hdMap.get(i);
		int minindex=Integer.MAX_VALUE;
		for(Integer val:list) {
			if(levelOrder.indexOf(val)<minindex)
				minindex=levelOrder.indexOf(val);
		}
		System.out.print(levelOrder.get(minindex)+" ");
	}
	
}


/*
  * Get the HDMAP of all the elements of a tree
  * 
  */
 public static void getHdMap(TreeNode current,int distance) {
	 int currentDistance=distance;
	 if(current!=null) {
		  if(!hdMap.containsKey(distance)) {
			  List<Integer> list=new ArrayList<Integer>();
			  list.add(current.getData());
			  hdMap.put(distance, list); 
		  }
		  else {
			  List<Integer> list=hdMap.get(distance);
			  list.add(Integer.valueOf(current.getData()));
			  hdMap.put(distance, list);
		  }
		  getHdMap(current.getLeftNode(),--currentDistance);
		  //reset it
		  currentDistance=distance;
		  getHdMap(current.getRightNode(),++currentDistance);
	  }
 	}
 
 	public static void levelOrder(TreeNode root) {
 		TreeNode temp;
 		Queue<TreeNode> queue=new LinkedList<TreeNode>();
 		if(root==null)
 			return;
 		    queue.add(root);
 			while(!queue.isEmpty()) {
 				temp=queue.poll();
 				//Process current node
 				levelOrder.add(temp.getData());
 				if(temp.getLeftNode()!=null)
 					queue.add(temp.getLeftNode());
 				if(temp.getRightNode()!=null)
 					queue.add(temp.getRightNode());
 			
 			}
 	     }
 	
}
