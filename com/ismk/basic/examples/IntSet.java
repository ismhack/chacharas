package com.ismk.basic.examples;

public class IntSet {
	
	
	private int[] intSet;
	private int count;
	
	public IntSet() {
		intSet = new int[100];
		count=0;
		
	}
	
	public void insert(int x) {
		
		//if(!member(x, count) && count <100 ) {
			
			intSet[count] = x;
			count++;			
		//}
		
		
	}
	
	public IntSet union(IntSet another) {
		
		
		IntSet temp = new IntSet();
		
		for(int i=0; i<count; i++) {
			
			temp.insert(intSet[i]);
			
		}
		
		for(int i=0; i<another.count; i++) {
			
			temp.insert(another.intSet[i]);
		}
		
		return temp;
		
		
	}
	
	public IntSet intersect(IntSet another) {
		
		IntSet temp = new IntSet();
		
		for(int i=0; i<another.count; i++) {
			
			if(member(another.intSet[i], another.count)) {
				temp.insert(another.intSet[i]);
			}
		}
		
		return temp;
		
	}
	
	public IntSet difference(IntSet another) {
		
		IntSet temp = new IntSet();
		for(int i=0; i<count; i++) {
			
			if(!another.member(intSet[i], another.count)) {
				temp.insert(intSet[i]);
				
			}
		}
		
		return temp;
	}
	
	
	public void delete(int x) {
		
		if(member(x, count)) {
			
			for(int i=0; i<count; i++) {
				
				if(intSet[i]== x) {
					intSet[i] = intSet[count-1];
					count--;
					break;
				}
			}
			
		}
		
		
	}
	
	
	public void sort() {
		
		for(int i=0; i<count-1; i++) {
			for(int j=0; j<count-1-i; j++) {
				if(intSet[j] > intSet[j+1]) {
					
					int temp = intSet[j];
					intSet[j] = intSet[j+1];
					intSet[j+1] = temp;
				}
				
				
			}
			
		}
	}
	
	
	public int partition(int start, int end) {
		
		int pivot=intSet[end];
		
		for(int i=0; i<end; i++) {
			
			if(intSet[i] < pivot) {
				
				int temp = intSet[i];
				intSet[i] = intSet[start];
				intSet[start] = temp;
				start++;
			}
			
		}

		int temp =  intSet[start];
		intSet[start] = intSet[end];
		intSet[end] = temp;
		
		return start;
	}
	
	public int partition_start(int start, int end) {
		
		int pivot=intSet[start];
		
		for(int i=start +1; i<=end; i++) {
			
			if(intSet[i] <= pivot) {
				
				start++;
				int temp = intSet[i];
				intSet[i] = intSet[start];
				intSet[start] = temp;
				
			}
			
		}

		int temp =  intSet[start];
		intSet[start] = intSet[end];
		intSet[end] = temp;
		
		return start;
	}
	
	public void quickSort( int start, int end) {
		
		if(start < end) {
		int partition = partition_start(start, end);
		
		
			quickSort(start, partition -1);
		
			quickSort(partition+1, end);
		}
			
	}
	
	public boolean member(int x, int count) {
		
		int i = count;
		if(i==0)
			return false;
		
		if(x != intSet[i-1]) {
			
			return member(x, i-1);
		}
		else {
			return true;
		}
			
			
			
	}
	
	
	public void display(int count) {
		
		int i = count;
		
		if(i <= 0)
			return;
		System.out.println(intSet[i-1]);
		display(i-1);
		
	}
	

	public static void main(String[] args) {
		
		IntSet set =  new IntSet();
		IntSet another =  new IntSet();
		
		set.insert(5);
		set.insert(5);
		set.insert(5);
		set.insert(5);
		set.insert(5);
		set.insert(5);
		set.insert(5);
		set.insert(5);
		
		set.quickSort(0, set.count-1);
		
		another.insert(3);
		another.insert(1);
		another.insert(2);
		another.insert(10);
		another.insert(6);
		another.insert(4);
		
		set.display(set.count);
		System.out.println("Delete 5");
		set.delete(5);
		set.display(set.count);
		
		
		IntSet union = set.union(another);
		IntSet intersect = set.intersect(another);
		IntSet difference = set.difference(another);
		System.out.println("another");
		another.display(another.count);
		System.out.println("UNION");
		union.display(union.count);
		System.out.println("INTERSECT");
		intersect.display(intersect.count);
		System.out.println("DIFFERENCE");
		difference.display(difference.count);
		
	}

}
