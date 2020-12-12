package com.ismk.basic.examples;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
	
	
	static int pow(int base, int p) {
		
		if(p==0)
			return 1;
		
		return base * pow(2, p-1);
	}
	static int temp = Integer.MIN_VALUE;
	
	static int findMaxDiffSubsets(int[] a,int k) {
		
		

		return temp;
		
	}
	
	/*
	 * Input: A = [1, 2, 3, 4, 5, 6]
	 * Output: 10
	 */
	private static class DataSet{
		
		int position;
		int add;
		public DataSet(int pos, int add) {
			this.position = pos;
			this.add = add;
		}
	}
	static DataSet contiguousSum(int[] a) {
		
		if(a.length == 0 || a.length == 1)
			return new DataSet(0, 0);
		
		int[] suffix = new int[a.length];
		int[] prefix = new int[a.length];
		
		prefix[0] = a[0];
		for(int i=1; i<a.length; i++) {
			
			prefix[i] = prefix[i-1]+a[i];
		}
		
		
		suffix[a.length- 1] = a[a.length-1];
		for(int i=a.length-2; i>=0; i--) {
			
			suffix[i] = suffix[i+1] + a[i];
			
		}
		
		int min = suffix[0];
		int pos=0;
		
		for(int i=0; i<a.length-1; i++) {
			
			if(Math.abs( prefix[i] - suffix[i +1 ] ) < min) {
				
				min = Math.abs( prefix[i] - suffix[i +1 ] );
				
				if(prefix[i] > suffix[i +1 ])
					pos =  i+1;
				else
					pos=i;
			}
			
		}
		
		return new DataSet(pos, min);
		
	}
	
	
	private static class JSON {
		Integer value;
		List<JSON> children;
		
		public JSON() {
			this.value = null;
			this.children = new ArrayList<Recursion.JSON>();
		}
		public JSON(Integer val) {
			this.value = val;
			this.children = new ArrayList<Recursion.JSON>();
		}
		public void setValue(Integer value) {
			
			this.value = value;
			
		}
		
		public void setChildre(List<JSON> children) {
			this.children = children;
		}
		
		public String serialize() {
			

			return serializeUtil(this); 
			
		}
		
		public String serializeUtil(JSON json) {
			
			if(json.value != null) {
				return json.value.toString();
			}
			else {
				String result = "[";
				for(JSON child : json.children) {
					
					result += serializeUtil(child) +",";
				}
				
				if(result.endsWith(","))
					result = result.substring(0, result.lastIndexOf(','));
				
				result += "]";
				return result;
			}
		}
		
		
	}
	


	public static void main(String[] args) {
		System.out.println("pow(2,3): "+pow(2,3));
		
		
		int a[] = { 8,4,5,2,10}; 
		DataSet values = contiguousSum(a); 
	    System.out.println("Minimum element : " + values.add  
	        + "\nPosition : " + values.position);
	    
	    
	    //System.out.println("findMaxDiffSubsets: "+ findMaxDiffSubsets(a, a.length, 2,0,0, 0, 0));
	    
	    JSON json = new JSON();
	    
	    List<JSON> children =  new ArrayList<Recursion.JSON>();
		//[10,23,554,[33,[75,434,45],[]],[] ]

	    children.add(new JSON(10));
	    children.add(new JSON(23));
	    children.add(new JSON(554));

	   
	    List<JSON> children2 =  new ArrayList<Recursion.JSON>();
	    JSON child2 =  new JSON(33);
	    
	    children2.add(child2);
	    
	    List<JSON> children3 =  new ArrayList<Recursion.JSON>();
	    children3.add(new JSON(75));
	    children3.add(new JSON(434));
	    children3.add(new JSON(45));
	    
	    
	    List<JSON> children4 =  new ArrayList<Recursion.JSON>();
	    
	    JSON child4 = new JSON();
	    child4.setChildre(children4);
	    
	    children3.add(child4);
	    
	    JSON child3 =  new JSON();
	    child3.setChildre(children3);
	    
	    children2.add(child3); 
	    
	    
	    
	    List<JSON> children5 =  new ArrayList<Recursion.JSON>();
	    JSON child5 = new JSON();
	    
	    child5.setChildre(children5);
	    children2.add(child5);
	    
	    JSON child = new JSON();
	    
	    child.setChildre(children2);
	    

	    children.add(child);
	    
	    json.setChildre(children);
	    
	    System.out.println("JSON: "+json.serialize());

	}

}
