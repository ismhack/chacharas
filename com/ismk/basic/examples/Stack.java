package com.ismk.basic.examples;


public class Stack {
	

	static class Node{
		
		String value;
		Node next;
		
		Node(String value) {
			this.value=  value;
			next= null;
			
		}
	}
	Node top;
	public Stack() {top = null;}

public void push(String data) {
	
	Node new_node = new Node(data);
	
	if(top == null) {
		
		top = new_node;
	}
	else {
		Node temp = top;
		top = new_node;
		new_node.next=temp;
	}
	
	
}

public String pop() {
	
	if(top == null) {
		return null;
	}
	else {
		Node value = top;
		top = top.next;
		return value.value;
	}
	
}
	
	
	 public static void printList(Stack list) 
	    { 
	        Node currNode = list.top; 
	   
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
	   
	public static void main(String[] args) {
		
		
		Stack list = new Stack(); 
		
  
        // Insert the values 
        list.push("a"); 
        list.push("b"); 
        list.push("c"); 
        list.push("d"); 
        list.push("f"); 
        list.push("g"); 
        list.push("h"); 
        list.push("i"); 
  
        // Print the LinkedList 
        printList(list); 
        
        System.out.println("\n pop "+list.pop());
        printList(list);
        
        System.out.println("\n pop "+list.pop());
        printList(list);
	}

}



