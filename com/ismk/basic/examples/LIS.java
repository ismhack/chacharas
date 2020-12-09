package com.ismk.basic.examples;

import java.util.Arrays;

public class LIS {
	
	
	public static int findLIS(int[] array){
		
	//return LISSlow(array, 0, Integer.MIN_VALUE);
		
	/*	 int [][] memo = new int[array.length + 1][array.length];
		 
		 
		 for(int row[]: memo) {
			 
			 Arrays.fill(row, -1);
		 }
		 
		 return LISMedium(array, 0, -1, memo);
	*/
		return LISMedium2(array);
	}
	
	
	public static int LISSlow(int[] array, int index, int previous) {
		
		if(index == array.length)
			return 0;
		
		int temp = 0;
		if(array[index] > previous)
		 temp = 1 +  LISSlow(array, index + 1, array[index]);
		
		return Math.max(temp, LISSlow(array,index + 1 , previous ));
		
	}
	
	
	public static int LISMedium(int[] array, int index, int previous, int [][] memo) {
		
		int temp=0, temp2=0;
		if(array.length == index)
			return 0;
		
		if(memo[previous+1][index] >0) {
			
			return memo[previous+1][index];
		}
		
		if(previous ==-1 || array[index] >  array[previous])
			temp = 1 + LISMedium(array, index +1 , index, memo); 
		
		temp2 = LISMedium(array, index+1, previous, memo);
		
		memo[previous +1][index] = Math.max(temp, temp2);
		return memo[previous +1][index];
		
	}
	
	public static int LISMedium2(int[] array) {
		
		int localMax = 0, globalMax =0;
		int[] dp = new int[array.length];
		
		dp[0] = 1;
		
		if(array.length == 0)
			return 0;
		
		for(int i=1; i<array.length; i++) {
			localMax =0;
			for(int j=0; j<i; j++) {
				if(array[i] > array[j])
					localMax = Math.max(localMax, dp[j]);
				
			}
			
			dp[i] = 1 + localMax;
			globalMax = Math.max(globalMax, dp[i]);
		}
		
		return globalMax;
		
	}
	
	
	 // driver program to test above functions 
    public static void main(String args[]) 
    { 
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 }; 
        System.out.println("Length of lis is " + findLIS(arr) + "\n"); 
    } 

}
