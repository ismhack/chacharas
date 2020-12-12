package com.ismk.basic.examples;

public class CustomList {
	
	
	
	static class Node{
		
		String value;
		Node next;
		
		Node(String value) {
			this.value=  value;
			next= null;
			
		}
	}
	Node head;
	public CustomList() {head = null;}

	public CustomList removeLast(CustomList list) {
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
	
	
	 public static void printList(CustomList list) 
	    { 
	        Node currNode = list.head; 
	   
	        System.out.println("LinkedList: "); 
	   
	        // Traverse through the LinkedList 
	        while (currNode != null) { 
	            // Print the data at current node 
	            System.out.print(currNode.value + " "); 
	   
	            // Go to next node 
	            currNode = currNode.next; 
	        } 
	        System.out.println();
	    }
	 
	    // Method to insert a new node 
	    public void insert( String data) 
	    { 
	        // Create a new node with given data 
	        Node new_node = new Node(data); 
	        new_node.next = null; 
	  
	        // If the Linked List is empty, 
	        // then make the new node as head 
	        if (head == null) { 
	            head = new_node; 
	        } 
	        else { 
	            // Else traverse till the last node 
	            // and insert the new_node there 
	            Node last = head; 
	            while (last.next != null) { 
	                last = last.next; 
	            } 
	  
	            // Insert the new_node at last node 
	            last.next = new_node; 
	        } 
	  
	     
	    } 
	    
	    public void delete(String x) {
	    	
	    	 if (head == null) { 
		            //nothing to delete
	    		 return;
		      } 
	    	 else {
	    		 
	    		 Node last = head, prev=null;
		            while (last != null) { 
		            	
		            	if(last.value == x) {
		            		
		            		if(last == head) {
		            			
		            			head = last.next;
		            			last = null;
		            			return;
		            		}
		            		
		            		prev.next = last.next;
		            		last = null;
		            		return;
		            	}
		            	prev = last; 
		                last = last.next; 
		            } 
	    	 }
	    	
	    }
	    
	public static void main(String[] args) {
		
		
		CustomList list = new CustomList(); 
		  
        // 
        // ******INSERTION****** 
        // 
  
        // Insert the values 
        list.insert("a"); 
        list.insert("b"); 
        list.insert("c"); 
        list.insert( "d"); 
        list.insert( "f"); 
        list.insert("g"); 
        list.insert("h"); 
        list.insert("i"); 
  
        // Print the LinkedList 
        printList(list); 
        
        list.removeLast(list);
        
        printList(list);
        
        list.delete("a");
        printList(list);

	}

}
