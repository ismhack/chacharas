package com.ismk.basic.examples;

import java.util.HashMap;

public class ArrayProblems {

static int stackCalls = 0;	
	//recursive
	static boolean isSubsetSum(int[] a, int n, int sum) {
		
		if(sum == 0 )
			return true;
		
		if( n == 0 || sum <0)
			return false;
		
		System.out.println("recursive call no: "+ ++stackCalls + " for: "+n + "|" + sum);
		boolean exclude = isSubsetSum(a, n-1, sum);
		
		boolean include = isSubsetSum(a, n-1, sum - a[n-1]);
		
		return exclude || include;
		
	}
	
	static boolean isSubsetSum(int[] a, int n, int sum, java.util.HashMap<String, Boolean> lookUp) {
		
		if(sum == 0 )
			return true;
		
		if( n == 0 || sum <0)
			return false;
		
		 String key = n + "|" + sum;
		if(!lookUp.containsKey(key)) {
			System.out.println("recursive call no: "+ ++stackCalls + " for: "+key);
			boolean exclude = isSubsetSum(a, n-1, sum, lookUp);
			boolean include = isSubsetSum(a, n-1, sum - a[n-1], lookUp);
			
			lookUp.put(key, exclude || include);
		}
		
		return lookUp.get(key);
		
	}
	
	static boolean isSubsetSum(int[] a, int sum) {
		
		boolean[][] memo = new boolean[a.length+1][sum+1];
		
		//initialize first row as false
		for(int i=0; i<=sum; i++) {
			
			memo[0][i] = false;
		}
		//can form a subset with 0 elements

		for(int i=0; i<memo.length; i++) {
			
			memo[i][0] = true;
		}
		
		
		
		for(int i=1; i<memo.length; i++) {
			
			for( int j=1; j<=sum; j++ ) {
				
				if( j< a[i-1] )
					memo[i][j] = memo[i-1][j];
				else
					memo[i][j] = memo[i-1][j] || memo[i-1][j - a[i-1]];
							
			}
		}
		
		return memo[a.length][sum];
		
	}

	public static void main(String[] args) {
		
		int[] a = {3,34,4,12,5,2,9, 11,21,6,19,18};
		java.util.HashMap<String, Boolean> lookUp = new HashMap<String, Boolean>();
		stackCalls = 0 ;
		System.out.println("isSubsetSum: "+isSubsetSum(a, a.length, 17, lookUp) );
		System.out.println("Stack Calls: "+stackCalls);
		stackCalls =0;
		System.out.println("isSubsetSum: "+isSubsetSum(a, a.length, 17) );
		System.out.println("Stack Calls: "+stackCalls);
		
		System.out.println("isSubsetSum DP: "+isSubsetSum(a, 13));
	}

}
