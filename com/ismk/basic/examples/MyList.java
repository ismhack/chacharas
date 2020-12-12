package com.ismk.basic.examples;

public class MyList {
	
	private int value;
	private MyList next;
	
	public MyList(int val) {
		this.next=null;
		this.value = val;
	}
	
	public void setNext(MyList next) {
		this.next = next;
	}
	
	public MyList getNext() {
		return this.next;
	}
	
	public int getValue() {
		return this.value;
	}
	
	
	
	@Override
	public String toString() {
		MyList cur = this;
		String string ="[";
		while(cur!=null) {
			
			string += cur.value + " ";
			
			cur =cur.next;
			
		}
		
		string += "]";
		
		return string;
		
	}

	public static MyList mergeTwoSortedLists(MyList a, MyList b) {
		
		MyList newList = null, cur=null, root=null;
		
		if(a == null) {
			return b;
		}
		if(b == null) {
			return a;
		}
		
		while(a!=null || b!=null) {
			
			if(a != null && b!=null) {
				
				if(a.getValue() > b.getValue()) {
					
					newList =  new MyList(b.getValue());
					
					b = b.next;
				} else {
					
					newList =  new MyList(a.getValue());
					a = a.next;
					
				}

				
			} else {
				
				if(a !=null) {
					
					newList =  new MyList(a.getValue());
					a = a.next;
					
				}
				
				if(b !=null) {
					
					newList =  new MyList(b.getValue());
					b = b.next;
					
				}
				
				
			}
			
			if(cur == null) {
				
				cur = newList;
				root = cur;
			} else {
				
				cur.next = newList;
				cur = newList;
			}
			
			
			
		}//end-while
		
		return root;
		
		
	}
	
	
	public static void main(String[] args) {
		
		MyList a=null, b=null;
		
		MyList temp = new MyList(2);
		a=temp;
		temp.next = new MyList(9);
		temp = temp.next;
		temp.next =new MyList(12);
		temp = temp.next;
		temp.next =new MyList(20);
		temp = temp.next;
		
		temp = new MyList(11);
		b=temp;
		temp.next = new MyList(31);
		temp = temp.next;
		temp.next = new MyList(32);
		temp = temp.next;
		temp.next = new MyList(38);
		
		System.out.println("a: "+a);

		System.out.println("b: "+b);
		System.out.println("merged: " + mergeTwoSortedLists(a, b));
		
	}

}
