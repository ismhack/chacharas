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
		
		a.add(7);

		a.add(8);

		a.add(9);

		a.add(10);

		a.add(1);

		a.add(2);

		a.add(3);
		
		a.add(4);
		
		a.printArray();
		a.sort();
		
		a.printArray();
		
		
		System.out.println("median "+a.median());

	}

}
