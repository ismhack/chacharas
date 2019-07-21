package com.ismk.basic.examples;

public class Sample1 {
	
	public void bar(int[] array, int size) {
		
		int divident=0;
		int divisor=100;
		
		for(int i=0; i<size; i++) {
			
			divident= array[i]/divisor;
			print(divident,"*");
			
		}
		
	}
	
	
	public boolean validate(int[] arr, int size) {
		
		for(int i=0; i< size; i++) {
			
			if(arr[i]>100 || arr[i]<0)
				return false;
		}
		
		return true;
		
	}
	
	public void print(int count, String symbol) {
		
		String chain="";
		while(count>0) {
			chain = chain+symbol;
			count--;
		}
		
		System.out.println(chain);
	}
	
	public static void main(String[] args) {
		
		new Sample1().bar(new int[]{200,400,420,555,10000}, 5);
		
		
		System.out.println(new Sample1().validate(new int[] {-10,3,8,2}, 4));

		System.out.println(new Sample1().validate(new int[]{0,99,101,77,87}, 5));
		
		
	}

}
