package com.ismk.basic.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FBExamples {

	
	/*
	/*

	Given a unique sorted integer array A, and an integer k, 
	what is the number of triples x, y such that
	1. x, y are all unique elements in the array
	2. x + y + z = k

	Input:
	A: [1, 2, 3, 4, 6]
	k: 7

	Expected Output: 2
	*/
	
	
	static int findTriplesinArray(int[] array,  int k) {
		int total = 0;
		
		
		if(array == null || array.length <3)
			return 0;
		
		int front=0, back = array.length -1, temp=-1, foundIndex=-1 ;
		
		//find x and y such that x + y < k
		while( (back-front)>1) {
			
			if( array[front] + array[back] <= k) {
				
				temp = k - ( array[front] + array[back] );
				
				foundIndex=Arrays.binarySearch(array, front+1, back-1, temp );
				
				if( foundIndex >-1)
					total++;
				
				
				if(temp <= array[back])
					back --;
				else
					front ++;
			}
			else {
				
				back --;
				
			}
			
		}
		
		return total;
		
	}
	
	static int arrangeZeroToRight(int[] a) {
		
		if(a == null || a.length <1)
			return 0;
		
		int total=0, back=a.length-1;
		
		for(int i=0; i <a.length && i != back; i++) {
			
			if(a[i] == 0) {
				
				
				while(a[back] ==0) {
					back--;
				}
				
				try {
					swap(a,i,back);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				total++;
				
			}
			
				
		}
		
		
		return total;
	}
	
	static void swap(int[] a, int f, int t) throws Exception{
		
		if(f > a.length-1 || t > a.length-1 )
			throw new Exception("Error with parameters");
		
		int temp = a[f] ;
		a[f] = a[t];
		a[t] = temp;
		
	}
	
	
	//find all sorted triples in an array
	//example int a[] = {5,4,3,7,6,1,9}
	//out: [5,7,9] - [4,7,9] - [3, 7, 9] - [5, 6,9] - [4,6,9] - [3,6,9]
	/*
	 * part in half : 7
	 * [5 , 4 ,3, y, 6, x, 1] - [7, 9] 
	 *
	 */
	
	static void findSortedTriples(int[] a) {
		
		
		if(a == null || a.length <3)
			return ;
		
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < a.length; i++) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(a[i]);
			matrix.add(i, list); 

			for(int j=i+1; j<a.length; j++) {
				
				if(a[i] < a[j] ) {
					
					matrix.get(i).add(a[j]);
					
				}
				
			}
		}
		
		
		for( List<Integer> x : matrix ){
			int[] data = new int[3];
			combinationUtil(x, x.size(), 3, 0, data, 0);
		}
		
		
	}
	

	static void combinationUtil(List<Integer> arr, int n, int r, int index, int data[], int i) 
{ 
		// Current combination is ready to be printed, print it 
		if (index == r) 
		{ 
		for (int j=0; j<r; j++) 
		System.out.print(data[j]+" "); 
		System.out.println(""); 
		return; 
		} 
		
		// When no more elements are there to put in data[] 
		if (i >= n) 
		return; 
		
		data[index] = arr.get(i);
		combinationUtil(arr, n, r, index+1, data, i+1); 
		
		if(index+1 < r && data[index+1] < arr.get(i) )
		
		// current is excluded, replace it with next (Note that 
		// i+1 is passed, but index is not changed) 
		combinationUtil(arr, n, r, index, data, i+1); 
} 
	
	static void combinationUtil(List<Integer> arr, int r){
		
	}
	
	
	
	
	static void printArray(int[] a) {
		
		System.out.print("Array: ");
		
		for(int i: a)
			System.out.print(i + ",");
		
		System.out.println();
		
	}
	
	/*
	 * Word Break
	 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

		Note:
		
		The same word in the dictionary may be reused multiple times in the segmentation.
		You may assume the dictionary does not contain duplicate words.
		Example 1:
		
		Input: s = "leetcode", wordDict = ["leet", "code"]
		Output: true
		Explanation: Return true because "leetcode" can be segmented as "leet code".
	 */
	
    public boolean wordBreak(String s, List<String> wordDict) {
        
    boolean[] dp = new boolean[s.length() +1];
    
    Arrays.fill(dp, false);
           
        int size = s.length(); 
          
        // base case 
        if (size == 0) 
            return true; 
        
        for(int i=1; i<=size; i++){
            
            if(dp[i] == false && wordDict.contains(s.substring(0,i)) )
                dp[i]=true;
            
                 // wb[i] is true, then check for all substrings starting from 
                // (i+1)th character and store their results. 
            if (dp[i] == true) 
            { 
                // If we reached the last prefix 
                if (i == size) 
                    return true; 
            
                for(int j =i+1; j<=size; j++){

                   if(dp[j] == false && wordDict.contains(s.substring(i,j)) )
                    dp[j]=true;
                    
                    // If we reached the last character 
                    if (j == size && dp[j] == true) 
                        return true; 
                }
                
            }
            
        }
        
        
        return false;
    }
    
    public static boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> map) {
    	
    	if(map.containsKey(s))
    		return map.get(s);
    	
    	int size = s.length();
    	if( size == 0)
    		return true;
    	
    	for(int i=1; i<=size; i++) {
    		String left = s.substring(0, i);
    		if(wordDict.contains(left) ) {
    			String right = s.substring(i);
    			if(map.containsKey(s))
    				map.put(s, map.get(s)||wordBreak(right, wordDict, map));
    			else
    				map.put(s, wordBreak(right, wordDict, map));
    			
    			
    		}
    	}
    	
    	return map.containsKey(s) ? map.get(s):false;
    	
    }
    
    public static List<String> wordBreak2(String s, List<String> wordDict, Map<String, List<String>> map) {
        
    	List<String> results =new ArrayList<String>();
    	
    	if(map.containsKey(s))
    		return map.get(s);
    	
    	if(wordDict.contains(s))
    		results.add(s);
    
    
        for(int i=1; i<=s.length(); i++) {
        	
        	String left = s.substring(0,i);
        	
        	if(wordDict.contains(left)) {
        		
        		List<String> subList = wordBreak2(s.substring(i), wordDict, map);
        		
        		
        		for(String sub: subList) {
        			
        			results.add(left +" " + sub);
        		}
        		

        	}
        }
        
		map.put(s, results);
        	
        return results;
    }
    
    
    
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 6};//{-2,-1, 0, 2, 4, 6, 8, 10, 11};
		
		System.out.println("Triples: "+ findTriplesinArray(a,7));
		
		int[] b = {1,-2, 0, 6, 0, 4, -3 , 0};
		
		System.out.println("Arrange Zeroes: "+ arrangeZeroToRight(b));
		
		printArray(b);
		
		int[] c = {5, 4 ,3, 7, 6, 1, 9};
		//findSortedTriples(c);
		Map<String, List<String>> map =  new HashMap<String, List<String>>();
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and"); 
		wordDict.add("sand");
		wordDict.add("dog");
		List<String> words = new ArrayList<String>();
		words= wordBreak2(s, wordDict, map);
		
        System.out.println("list size " +words.size());
        
        for(String w: words) {
        	System.out.println("word list:" +w);
        }
        Map<String, Boolean> map2 =  new HashMap<String, Boolean>();
        s = "pineapplepenapple";
        wordDict.clear();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        map2.clear();
        System.out.println("found wordBreak: "+wordBreak(s, wordDict, map2));
        
        s = "abcd";
        wordDict.clear();
		wordDict.add("a");
		wordDict.add("abc");
		wordDict.add("b"); 
		wordDict.add("cd");
        map2.clear();
        System.out.println("found wordBreak: "+wordBreak(s, wordDict, map2));
		
       
		
	}
}
