package com.ismk.basic.examples;

public class QuickSort {
	
	
	public int partition(int[] array, int l, int h) {
		
		int p = array[h];
		
		int i = l -1;
		
		for(int j= l; j <= h-1; j++) {
			
			if(array[j] < p ) {
				
				i++;
				int t = array[j];
				array[j] = array[i];
				array[i] = t;
						
			}
		}
		
		int t = array[h];
		array[h] = array[i+1];
		array[i+1] = t;
		return (i+1);
		
	}
	
	public void quickSort(int[] array, int l, int h ) {
		
		if(l < h) {
			
			int p = partition(array, l, h);
			
			quickSort(array, l, p - 1);
			quickSort(array, p +1 , h);
		}
	}
	
	  static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i = 0; i < n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }

	public static void main(String[] args) {

		int[] array = {9,100,29,0,28,-9,-2,39,99,222,4,1,5,7};
		new QuickSort().quickSort(array, 0, 13);
		printArray(array);
	}

}
