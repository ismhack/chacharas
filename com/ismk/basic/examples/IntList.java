package com.ismk.basic.examples;

public class IntList {
	
	
	private int[] arr = null;
	private int num;
	
	public IntList() {
		
		arr=new int[100];
		num=0;
	}
	
	public void add(int x) {
		
		if(arr!= null && num < 100) {
			num++;
			arr[num -1] = x;
			
		}
		else {
			System.out.println("List is full");
		}
		
	}
	
	public void sort() {
		
		int n = num; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[i] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
		
	}
	
	public void quickSort( int start, int end) {
		
		int partition = partition(arr, start, end);
		
		if(partition-1 > start) {
			quickSort( start, partition -1);
		}
		if(partition+1 < end) {
			quickSort( partition+1, end);
		}
		
	}
	
	public boolean search(int x,int start, int end ) {
		
		int mid = (end + start)/2;
		
		if( start > end) {
			return false;
		}
		
		if(arr[mid] > x) {
			return search(x,start, mid-1);
		}
		if(arr[mid]< x) {
			return search(x,mid+1,end);
		}
		if(arr[mid]==x) {
			return true;
		}
		else return false;
		
	}
	
	public int indexOf(int x,int start, int end ) {
		
		int mid = start + (end - start)/2;
		
		if( start > end) {
			return -1;
		}
		
		if(arr[mid] > x) {
			return indexOf(x,start, mid-1);
		}
		if(arr[mid]< x) {
			return indexOf(x,mid+1,end);
		}
		if(arr[mid]==x) {
			return mid;
		}
		else return -1;
		
	}
	
	private int partition(int[] arr, int start, int end) {
		
		int pivot = arr[end];
		for(int i=start; i<end; i++) {
			
			if(arr[i] < pivot) {
			//swap arr[i] for arr[start]
				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				
				start++;
				
			}
		}
		
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		return start;
	}
	
	 void printArray() 
	    { 
	        int n = num; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    }
	 
	 public int sum() {
		 
		 int total=0;
		 for(int i=0; i<num; i++) {
			 
			 total = total + arr[i];
		 }
		 
		 return total;
	 }
	 
	 public double median() {
		 sort();
		 //even number of elements
		 if(num%2==0) {
			 return ((arr[(num/2)]+ arr[(num/2)-1])/2.0d);
		 }
		else {
			return arr[num/2];
			
		}
					 
			 
		 
	 }
	
	public static void main(String[] args) {
		
		
		IntList a= new IntList();
		
		a.add(11);

		a.add(10);

		a.add(8);

		a.add(6);

		a.add(5);

		a.add(9);

		a.add(3);
		
		a.add(4);
		
		a.printArray();
		a.quickSort(0,7);
		
		a.printArray();
		
		
		System.out.println("find "+a.search(-11, 0, a.num ));
		System.out.println("indexOf "+a.indexOf(-3, 0, a.num ));

		
		System.out.println("median "+a.median());
		
		
		for(int i=1; i<100; i *= 2)
			System.out.println(i);

	}

}
