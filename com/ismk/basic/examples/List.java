package com.ismk.basic.examples;

public class List {
	
	
	
	static class Node{
		
		String value;
		Node next;
		
		Node(String value) {
			this.value=  value;
			next= null;
			
		}
	}
	Node head;
	public List() {head = null;}

	public static List removeLast(List list) {
		Node current = list.head, prev=null;
		
		if(current != null) {
			
			while(current.next != null) {
				prev = current; 
				current = current.next;
				
			}
			prev.next = null;
			current = null;
			
			
			
		}
		
		return list;
		
	}
	
	
	 public static void printList(List list) 
	    { 
	        Node currNode = list.head; 
	   
	        System.out.print("LinkedList: "); 
	   
	        // Traverse through the LinkedList 
	        while (currNode != null) { 
	            // Print the data at current node 
	            System.out.print(currNode.value + " "); 
	   
	            // Go to next node 
	            currNode = currNode.next; 
	        } 
	    }
	 
	    // Method to insert a new node 
	    public static List insert(List list, String data) 
	    { 
	        // Create a new node with given data 
	        Node new_node = new Node(data); 
	        new_node.next = null; 
	  
	        // If the Linked List is empty, 
	        // then make the new node as head 
	        if (list.head == null) { 
	            list.head = new_node; 
	        } 
	        else { 
	            // Else traverse till the last node 
	            // and insert the new_node there 
	            Node last = list.head; 
	            while (last.next != null) { 
	                last = last.next; 
	            } 
	  
	            // Insert the new_node at last node 
	            last.next = new_node; 
	        } 
	  
	        // Return the list by head 
	        return list; 
	    } 
	public static void main(String[] args) {
		
		
		List list = new List(); 
		  
        // 
        // ******INSERTION****** 
        // 
  
        // Insert the values 
        list = insert(list, "a"); 
        list = insert(list, "b"); 
        list = insert(list, "c"); 
        list = insert(list, "d"); 
        list = insert(list, "f"); 
        list = insert(list, "g"); 
        list = insert(list, "h"); 
        list = insert(list, "i"); 
  
        // Print the LinkedList 
        printList(list); 
        
        list =removeLast(list);
        
        printList(list);

	}

}
