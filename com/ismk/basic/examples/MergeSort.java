package com.ismk.basic.examples;

public class MergeSort {
	
	
	public void merge(int[] arr, int l, int m, int r) {
		
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        
        System.out.println("n1 "+n1);
        System.out.println("n2 "+n2);
		
		/* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
		
	}
	
	public void mergeSort(int[] array, int l, int r) {
		
		
		if(l < r) {
			int m = (l + r)/2;
		
			mergeSort(array, l, m);
			mergeSort(array, m+1, r);
			
			merge(array, l, m, r);
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
		new MergeSort().mergeSort(array, 0, 13);
		printArray(array);
		
	}

}
