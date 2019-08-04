package com.ismk.basic.examples;


public class Queue {
	
	
static class Node{
		
		String value;
		Node next;
		
		Node(String value) {
			this.value=  value;
			next= null;
			
		}
	}
	Node top;
	Node rear;
	public Queue() {
		top = null;
		rear = null;
		}
	
	
	public void push(String val) {
		
		Node newNode = new Node(val);
		
		if(isEmpty()) {
			rear = newNode;
			top = rear;
			
		}
		else
		rear.next = newNode;
		rear = newNode;
		
	}
	
	public String pop() {
		
		if(isEmpty()) {
			
			System.out.println("Empty Queue");
			return null;
		}
		
		String val = top.value;
		top = top.next;
		
		return val;
		
	}
	
	public boolean isEmpty() {
		
		if(top == null)
			return true;
		else 
			return
					false;
		
	}
	
	 public static void printList(Queue list) 
	    { 
	        Node currNode = list.top; 
	   
	        System.out.println("LinkedList: "); 
	   
	        // Traverse through the LinkedList 
	        while (currNode != null) { 
	            // Print the data at current node 
	            System.out.print(currNode.value + " "); 
	   
	            // Go to next node 
	            currNode = currNode.next; 
	        } 
	    }
	 

	public static void main(String[] args) {
		
		
		Queue list = new Queue(); 
		
		  
        // Insert the values 
        list.push("a"); 
        list.push("b"); 
        //list.push("c"); 
        list.push("d"); 
        //list.push("f"); 
        //list.push("g"); 
        //list.push("h"); 
        //list.push("i"); 
  
        // Print the Queue 
        printList(list); 
        
        System.out.println("\n pop "+list.pop());
        printList(list);
        
        System.out.println("\n pop "+list.pop());
        printList(list);
         
        list.push("x");
        printList(list);

	}

}
