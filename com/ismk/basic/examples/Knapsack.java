package com.ismk.basic.examples;

public class Knapsack {
	
	private static int solve(int[] val, int[] wt, int w) {
		
		if(val == null || wt ==null)
			return 0;
		
		int n = val.length;
		
		int[][] mat = new int[n + 1][w + 1];
		
		for(int i=0; i<=w; i++) {
			mat[0][i] = 0;
		}
		
		for(int i=0; i<=n; i++) {
			mat[i][0] = 0;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=w; j++) {
				
				int maxValueWith = 0;
				int maxValueWithOut = mat[i -1][j];
				
				if(j >= wt[i-1]) {
					
					maxValueWith = val[i-1] ;
					int remCapacity = j - wt[i-1];
					maxValueWith += mat[i -1][remCapacity];
					
				}
				mat[i][j] = Math.max(maxValueWith, maxValueWithOut);
			}
		}
		
		return mat[n][w];
		
	}

	public static void main(String[] args) {
		
		int[] val = {10,40,30,50};
		int[] wt = {5,4,6,3};
		int w = 10;
		System.out.println(solve(val, wt, w));
	}

}
