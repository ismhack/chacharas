package com.ismk.basic.examples;

public class Modulo {
	
	public static int numPairsDivisibleByX(int[] time, int x) {
	        
	        int count=0;
	        int[] modulo = new int[x];
	        
	        for(int i=0; i< time.length; i++){
	            
	            if(time[i]%x ==0) {
	                count += modulo[0];
	            }
	            else {
	                count += modulo[x - time[i]%x];
	            }
	            modulo[ time[i] % x] ++;
	        }
	        
	        return count;
	     
	        
	    }

	public static void main(String[] args) {
		
		
		int[] input = {10,20,40,3,19,34};
		
		
		System.out.println("how many pairs: "+numPairsDivisibleByX(input, 4));
		
		
	}

}
