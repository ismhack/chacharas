package com.ismk.basic.examples;

public class SubArray {

	/*
	 * Given two arrays A[] and B[] consisting of n and m integers. The task is to check whether the array B[] 
	 * is a subarray of the array A[] or not.

		Examples:
		
		Input : A[] = {3, 3, 0, 5, 1, 1, 2}, B[] = {3, 0, 5, 1}
		Output : Yes
		
		Input : A[] = {1, 2, 3, 4, 5}, B[] = {2, 5, 6}
		Output : No
	 */
	
	public static boolean isSubArray(int[] A, int[] B) {
		
		int j = 0, i = 0;
		while( i <A.length ) {
			
			if(A[i] == B[j]) {
				i++;
				j++;
			}
			else {
				if(j >0) {
					j = 0;
				} else {
					i++;
				}
			}
			
			if(B.length == j) {
				return true;
			}
		}
		
		return false;
		
		
	}
	public static void main(String[] args) {
		
		int A[] = {1, 2, 3, 4, 5}, B[] = {2, 5, 6};
		
		System.out.println(isSubArray(A, B));

	}

}
