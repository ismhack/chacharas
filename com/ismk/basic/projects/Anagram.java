package com.ismk.basic.projects;

import java.io.*;
import java.math.*;
import java.nio.charset.Charset;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Anagram {
	


	    // Complete the sherlockAndAnagrams function below.
	    static int sherlockAndAnagrams(String s) {
	    	    HashMap<String, Integer> map = new HashMap<String, Integer>();

	    	    // Keep track of how many anagrams we've seen
	    	    int totalCount = 0;

	    	    // Generate all substrings (N^2)
	    	    for(int i = 0 ; i < s.length(); i++)
	    	    {
	    	        for(int j=i+1 ; j <= s.length(); j++)
	    	        {
	    	            String currentSubString = s.substring(i,j);

	    	            // Sort all strings E.g. ab & ba both == ab now
	    	            char[] chars = currentSubString.toCharArray();
	    	            Arrays.sort(chars);
	    	            currentSubString = String.valueOf(chars);

	    	           /* int value = map.getOrDefault(currentSubString, 0);
	    	            totalCount += value;
	    	            map.put(currentSubString, ++value);
	    	            */
	    	            
	    	            if(map.containsKey(currentSubString)) {
	    	            	
	    	            	int value = map.get(currentSubString);
	    	            	totalCount += value;
	    	            	map.put(currentSubString, ++value);
	    	            }else {
	    	            	map.put(currentSubString, 1);
	    	            }
	    	            
	    	        }
	    	    }
	    	    return totalCount;

	    }
	    
	    static int lcs(char[] X, char[] Y, int m, int n) {
	    	//N
	    	//Set<String> setA = a.chars().mapToObj(c -> (char) c+"").collect(Collectors.toSet());
	    	//Set<String> setB = b.chars().mapToObj(c -> (char) c+"").collect(Collectors.toSet());
	    	
	    	//N
	    	   int L[][] = new int[m+1][n+1]; 
	    	   
	    	    /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
	    	         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
	    	    for (int i=0; i<=m; i++) 
	    	    { 
	    	      for (int j=0; j<=n; j++) 
	    	      { 
	    	        if (i == 0 || j == 0) 
	    	            L[i][j] = 0; 
	    	        else if (X[i-1] == Y[j-1]) 
	    	            L[i][j] = L[i-1][j-1] + 1; 
	    	        else
	    	            L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
	    	      } 
	    	    } 
	    	  return L[m][n]; 
	    	
	    	
	    	
	    }
	    
	    static int lis(int[] arr, int n) {
	    	
	    	int[] list = new int[n];
	    	int max=1;
	    	
	    	for(int i=0; i<n; i++)
	    		list[i] = 1;
	    	
	    	for(int i=0; i <n; i++)
	    		for(int j=1; j<n; j++)
	    			if(arr[i]> arr[j] && list[i] < list[j]+1 )
	    				list[i] = list[j]+1;
	    	
	    	for(int i=0; i<n; i++)
	    		if(list[i] > max)
	    			max = list[i];
	    	
	    	return max;
	    	
	    }
	    
	    static int longestCommonChild(String x, String y) {
	    	
	    	
	    	return lcs(x.toCharArray(), y.toCharArray(), x.length(), y.length());
	    }

	    static boolean isAnagram(String a, String b){
	        char[] array = a.toCharArray();
	        char[] arrayb = b.toCharArray();
	        Arrays.sort(array);
	        Arrays.sort(arrayb);
	        a = new String(array);
	        b = new String(arrayb);
	        if(a.intern() == b.intern())
	            return true;
	        else
	            return false;

	    }

	    static int checkSubstring(String a, String s, int from, int index){

	            if(s == null || (from + a.length()) > (s.length()) || a.length()==s.length())
	                return 0;
	            
	            if(isAnagram(a, s.substring(from, from + a.length())) && from != index)
	                return 1 + checkSubstring(a, s, from+1, index);
	            else
	                return checkSubstring(a, s, from+1, index);

	    }
	    
	    static int steadyGene(String gene) {
	    	
	    	int N = gene.length()/4;

	    	char[] geneArr = gene.toCharArray();
	    	HashMap<Character, Integer> score = new HashMap<>();
	    	score.put('A', 0);
	    	score.put('C', 0);
	    	score.put('T', 0);
	    	score.put('G', 0);
	    	
	    	for(Character c: geneArr) {
	    			
	    		score.replace(c, score.get(c)+1);
	    		
	    	}
	    	
	    		
	        int min = Integer.MAX_VALUE;

	        int i = 0;
	        int j = 0;

	        while (i < gene.length() && j < gene.length()) {
	            if (!balanced(N, score)) {
	            	score.put(gene.charAt(j), score.get(gene.charAt(j)) - 1);
	                //System.out.println(map);
	                j++;
	            } else {
	                min = Math.min(min, j - i);
	                score.put(gene.charAt(i), score.get(gene.charAt(i)) + 1);
	                //System.out.println(map);
	                i++;
	            }
	        }

	        return min;
	    }
	    
	    public static boolean balanced(int N, Map<Character, Integer> map) {
	        if (map.get('A') <= N && map.get('C') <= N && map.get('G') <= N
	                && map.get('T') <= N)
	            return true;

	        return false;
	    }
	    
	    
	    public static String greedyOrder(String a, String b) {
	    	
	    	int n = a.length();
	    	int m = b.length();
	    	String result="";
	    	Character at =' ', bt=' ';
	    	while(n>0 || m>0 ) {
	    		at = Character.MAX_VALUE;
	    		bt= Character.MAX_VALUE;
	    		if(n>0)
	    			at= a.charAt(0);
	    		if(m>0)
	    			bt= b.charAt(0);
	    		
	    		if(at < bt) {
	    			result += at.toString();
	    			a = a.length()>1? a.substring(1): "";
	    			n--;
	    		}
	    		else {
	    			result += bt.toString();
	    			b = b.length()>1? b.substring(1): "";
	    			m--;
	    		}		
	    		
	    	}
	    	
	    	return result;
	    }
	    
	    public static boolean checkInclusion(String s1, String s2) {
	    	
	        int[] count = new int[26];
	        for(char ch : s1.toCharArray()) {
	            count[ch-'a'] ++;
	        }
	        
	        int matches = 0;
	        int len = s1.length();
	        for(int i=0; i<s2.length(); i++) {
	            count[s2.charAt(i)-'a'] --;
	            if(count[s2.charAt(i)-'a'] >= 0) matches ++;
	            if(i >= len) {
	                count[s2.charAt(i-len)-'a'] ++;
	                if(count[s2.charAt(i-len)-'a'] > 0) matches --;
	            }
	            if(matches == len) return true;
	        }
	        return false;
	        
	    }


	public static void main(String[] args) {
		
		
		System.out.println("output: "+Anagram.sherlockAndAnagrams("abba"));
		System.out.println("output: "+Anagram.sherlockAndAnagrams("abcd"));
		System.out.println("output: "+Anagram.sherlockAndAnagrams("cdcd"));
		System.out.println("output: "+Anagram.sherlockAndAnagrams("ifailuhkqq"));
		System.out.println("output: "+Anagram.sherlockAndAnagrams("kkkk"));
		
		System.out.println("LCS "+longestCommonChild("SHINCHAN","NOHARAAA"));
		System.out.println("LCS "+longestCommonChild("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS","FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"));

		 int arr[] = {3, 10, 2, 1, 20};
	        int n = arr.length; 
	        System.out.println("Length of lis is " + lis(arr, n) + "\n");
	        
	        System.out.println("Steady gene: "+steadyGene("GAACAAAA"));
	        
	        System.out.println("Greedy ZZYYZZYYZZZAZZZB : " + greedyOrder("ZZYYZZZA","ZZYYZZZB"));
	       
	        System.out.println("score: " +checkInclusion("abb","ccdabba"));
	}

}
