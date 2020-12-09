package com.ismk.basic.examples;


import java.util.HashMap;
import java.util.Map;

public class VisaTest {

	public VisaTest() {
			
	}
	public String calcMaxProfit(String row, int p, int q){
		
		Map<Integer, int[]> vector = new HashMap<Integer, int[]>();
		
		if(row.length() < 0)
			return "";
		
		for(int i=0; i< row.length(); i++) {
			
			try {
				if(row.substring(i, i+3).intern() == "000") {
					vector.put(i, new int[] {i,i+2,p});
				}else if (row.substring(i, i+2).intern() == "01" || row.substring(i, i+2).intern() == "10") {
					vector.put(i, new int[] {i,i+1,q});
					
				}else {
					vector.put(i, new int[] {0,0,0});
				}
			} catch (Exception e) {
				
				continue;
			}
		}
		
		int[] results = new int[vector.size()];
		int i=0;
		for(Map.Entry<Integer, int[]> entry : vector.entrySet()) {
			
			results[i] = entry.getValue()[2];
			i++;
		}
		
		for(i=0; i < vector.size(); i++) {
			for(int j=i+1; j < vector.size(); j++) {
				if(vector.get(i)[1] < vector.get(j)[0] )
					results[j] = Math.max(results[j], results[i] + vector.get(j)[2]);
			}
		}
		
		for(int output:results)
			System.out.println(output);
		
		return results.toString();
		
	}
	
	   
	public static void main(String[] args) {
		
		
		String calcMaxProfit = new VisaTest().calcMaxProfit("0001000", 2, 3);
		
		System.out.println("calc "+calcMaxProfit);
		
	}
	
}
