package com.ismk.basic.examples;

public class Recursive1 {
	
	
	public int[] replace(int[] arr, int size, int x, int y) {
		
		int i =size-1;
		if(i<0) {
			return arr;
			
		}
		if(arr[i] == x) {
			arr[size-1]= y;
			return replace(arr,i,x,y);
		}
		else {
			return replace(arr,i,x,y);
		}
		
	}
	
	
	public int sumOfSquares(int num) {
		
		
		int count =num;
		
		if(count==0)
			return 0;
		
		else return sumOfSquares(count-1)+ (count*count);
		
	}

	public static void main(String[] args) {
		
		int[] arr = new Recursive1().replace(new int[] {0,2,0,5,6,0} ,  6, 0, 1);
		
		for(int i:arr){
				System.out.print(i+",");
		}
		
		System.out.println("squere sum "+ new Recursive1().sumOfSquares(5));
	}

}
