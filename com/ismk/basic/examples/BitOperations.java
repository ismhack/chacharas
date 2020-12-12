package com.ismk.basic.examples;

public class BitOperations {
	
	
	 public static int singleNumber(int[] nums) {
		    int a = 0;
		    for (int i : nums) {
		      a ^= i;
		    }
		    return a;
		    
	 }
	 
	 public static int singleNumberinTriple(int[] nums) {
		    int a = 0; 
		    boolean flag=false;
		    for (int i=0; i<nums.length; i++) {
		      if(flag) {
		    	a &= nums[i];
		      	flag = false;
		      }
		      else {
		    	  a ^= nums[i];
		    	  flag = true;
		      }
		    }
		    return a;
		    
	 }
	 

	public static void main(String[] args) {
		
		int[] a = {4,2,1,2,1};
		System.out.println(singleNumber(a));
		
		int[] b= {2,3,2,2};
		System.out.println(singleNumberinTriple(b));

	      String subString = "Learning";
	     
	      
	      System.out.println(subString.substring(2,3));
	   }

}
