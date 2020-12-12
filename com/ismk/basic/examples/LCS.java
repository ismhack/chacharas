package com.ismk.basic.examples;

import java.util.Arrays;

public class LCS {
	
	
	static int findLCS(char[] a, char[] b) {
		
		
		//return LCS(a, b, 0, 0);
		
		
	/*	int [][] memo = new int[a.length + 1][b.length+1];
		 
		 
		 for(int i=0; i<memo.length; i++) {
			 
			 memo[i][0] =0;
		 }
		 
		 for(int i=0; i < memo[0].length; i++) {
			 
			 memo[0][i] = 0;
		 }
		
		return LCSMemo(a, b, 0, 0, memo);*/
		
		return LCSMemoD(a, b);
	}
	
	
	static int LCS(char[] a, char[] b, int indexA, int indexB) {
		
		if(indexA == a.length || indexB == b.length)
			return 0;
		
		int temp = 0;
		if(a[indexA] == b[indexB] )
			temp = 1 + LCS(a, b, indexA + 1, indexB +1 );
		
		
		int temp2 = Math.max(LCS(a,b, indexA, indexB +1), LCS(a,b, indexA +1, indexB));
		
		return Math.max(temp, temp2);
		
	}
	
	
	static int LCSMemo(char[] a, char[] b, int indexA, int indexB, int[][] memo) {

		
		if(indexA == a.length || indexB == b.length)
			return 0;
		
		int temp = 0;
		
		if(memo[indexA+1][indexB +1] > 0)
			return memo[indexA +1][indexB +1];
		
		if(a[indexA] == b[indexB] )
			temp = 1 + LCS(a, b, indexA + 1, indexB +1 );
		
		int temp2 = Math.max(LCS(a,b, indexA, indexB +1), LCS(a,b, indexA +1, indexB));
		
		memo[indexA+1][indexB+1] = Math.max(temp, temp2);
		
		return memo[indexA+1][indexB+1];
		
	}
	
	static int LCSMemoD(char[] a, char[] b) {
		
		
		int[] dp = new int[a.length];
		Arrays.fill(dp, 0);
		int globalMax = 0, localMax=0;
		
		for(int i=1; i<a.length; i++) {
			for(int j=0; j<i && j <b.length; j++) {
				
				if(a[i] == b[j])
					localMax = localMax +1;
				
			}
			dp[i]= localMax + 1;
			localMax = dp[i];
			globalMax = Math.max(globalMax, dp[i]);
		}
		
		return globalMax;
		
	}

	public static void main(String[] args) {
		
		System.out.println("LCS: "+ findLCS("paraguas".toCharArray(), "parus".toCharArray()));
		
	}

}
