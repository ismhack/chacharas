package com.ismk.basic.examples;

import java.util.ArrayList;
import java.util.List;

public class AllPairsInArray {
	
	/*
	 * Given a sorted array. Find all the pairs whose product is less than or equal to a given value in O(n).
	 * 
	 * int[] a = {2, 4, 5, 6, 9, 11}, value = 8;, val = 20
	 * 
	 * [2,4]
	 * 
	 * int[] a= {1, 2, 6, 7, 9, 10  }, value = 10;
	 * 
	 * [1,10]
	 * [9,1]
	 * [7,1]
	 * [6,1]
	 * [2,1]
	 */
	
	public static class Pair{
		int a, b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b =b;
		}

		@Override
		public String toString() {
			return "[a=" + a + ", b=" + b + "]";
		}
		
		
	}
	
	public static List<Pair> solve(int[] a, int value ){
		
		List<Pair> output = new ArrayList<Pair>();
		
		int i = 0, j =a.length-1;
		while(i != j) {
			int product = a[i] * a[j];
			if( product > value) {
				j --;
			}
			else if(product <= value) {
				Pair temp = new Pair(a[i], a[j]);
				output.add(temp );
				j --;
				
			}
			else {
				Pair temp = new Pair(a[i], a[j]);
				output.add(temp );
				i ++;
			}
			
		}
		
		return output;
		
	}
	
	public static void main(String[] args) {
		
		int[] a={2, 4, 5, 6, 9, 11};
		for(Pair p: solve(a, 10) ) {
			
			System.out.println(p);
			
		}
		
	}

}
