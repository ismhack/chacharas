package com.ismk.basic.examples;

import java.util.Arrays;

public class LCSLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            if(maxans < dp[i]) {
            	maxans = dp[i];
            	System.out.println("i: "+i+" maxval: "+maxans);
            }
            //maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    
    public String LCSubstring(char[] s1, char[] s2,int i , int j, String string) {
    	if (j<0 || i<0)
    		return string;
    	if(s1[i] == s2[j]) {
    		string = s1[i]+string;
    		string = LCSubstring(s1,s2,i-1,j-1, string);
    		
    	}
    	String lcSubstring = LCSubstring(s1,s2,i,j-1, "");
    	String lcSubstring2 = LCSubstring(s1,s2,i-1,j, "");
    	
    	if(lcSubstring.length() > lcSubstring2.length()) {
    		
    		if(lcSubstring.length() > string.length())
    			return lcSubstring;
    			else
    				return string;
    	}else 
    		{
    		if(lcSubstring2.length() > string.length())
    			return lcSubstring2;
    			else
    				return string;
    		}
    }
    
    public static void main(String[] args) {
    	LCSLIS s = new LCSLIS();
    	System.out.println(s.lengthOfLIS(new int[] {1,2,11,20,21,22,4,5,6,7,28}));

    	char[] s1 = "pchangatutorial".toCharArray();
    	char[] s2 = "abtutorialxtoo".toCharArray();
    	
    	String string = s.LCSubstring(s1, s2,s1.length-1,s2.length-1, "");

    		System.out.println("final: " +string);
    }
    
}