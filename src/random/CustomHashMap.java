package random;

import java.util.Map;
import java.util.Objects;


/*
 * Bare minimum implementation of hashmap
 * @author Satyaki Bose
 * 
 */
public class CustomHashMap<K,V> {
	
	private static final double LOAD_FACTOR = 0.75;

	transient Node<K,V>[] table;
	
	private static int INITIAL_CAPACITY=16;

	public CustomHashMap() {
		table=new Node[INITIAL_CAPACITY];
	}
	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<table.length;i++) {
			Node<K,V> node=table[i];
			if(node==null)
				continue;
			if(node.next==null)
			{
				sb.append("["+node.getKey()+"]"+" --> {"+node.getValue()+"}"+"\n");
			}
			else {
				sb.append("["+node.getKey()+"]"+" --> {"+node.getValue()+",");
				while(node.next!=null) {
					sb.append(node.next.getValue()+",");
				}
				sb.append("}"+"\n");
			}
		}	
		return sb.toString();
	}
	
	/*
	 * put values into the map
	 * 
	 */
	public void put(K key, V value) {
		//index will be the hashbucket
		int hash=hash(key);	
		int size = table.length;
		int index = (size - 1) & hash;
		//Original : resize table and rehash ,check if the array is full or not based on a load factor
		//here is a basic implementation of copying over without rehashing
		if(table.length>(LOAD_FACTOR*INITIAL_CAPACITY)){
			Node<K,V>[] newtable=new Node[INITIAL_CAPACITY*2];
			System.arraycopy(table, 0, newtable, 0, table.length);
			INITIAL_CAPACITY=INITIAL_CAPACITY*2;
			this.table=newtable;
		}
		//bucket is empty at that index,push it
	    if (table[index] == null)
	    	table[index] = newNode(hash, key, value, null);
	    else {	
	    	//If collision happen handle it by creating a linked list,use equals to check if the value is different
	    	if (table[index] != null) {
	    		Node<K,V> node=table[index];
	        	K k = node.key;
	    		if(node.hash == hash&&(k = node.key) == key || (key != null && key.equals(k))) {
	    			//dont do anything
	    		}
	    		else {
	    			node.next=newNode(hash, key, value, null);
	    		}
	    	}
	    }	
	}
	
	/*
	 * Get values from the map via a key
	 * 
	 */
	public V get(K key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
	}

	private Node<K, V> getNode(int hash, K key) {
		int n = table.length;
		if(table!=null&&table.length>0) {
			Node<K,V> first = table[(n - 1) & hash] ;
			if(first==null)
				return null;
			K k=first.key;
			if (first.hash == hash && // always check first node
	                ((first.key) == key || (key != null && key.equals(k))))
	                return first;
			while(first.next!=null) {
				if (first.next.hash == hash && // always check first node
		                ((first.next.key) == key || (key != null && key.equals(k))))
		                return first.next;
			}
		  }
		return null;
	}

	static final int hash(Object key) {
          int h;
          return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
      
    // Create a regular (non-tree) node
    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
        return new Node<>(hash, key, value, next);
    } 

	static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }
  
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }     
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
   }

     
	
}