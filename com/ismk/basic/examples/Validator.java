package com.ismk.basic.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Validator {
	
	 static char OPEN_CURLY_BRACES = '{';
	 static char CLOSE_CURLY_BRACES = '}';
	 static char OPEN_PARENTESIS = '(';
	 static char CLOSE_PARENTESIS = ')';
	 static char OPEN_BRACES ='[';
	 static char CLOSE_BRACES =']';
	 static Stack<String> st = new Stack<String>();
	
	 
	 public static boolean verifyClosing(String v) {
		 
		 char last_pop;
		 
		 for(char c :v.toCharArray()){
			 
			 if( c==OPEN_CURLY_BRACES || c== OPEN_BRACES || c==OPEN_PARENTESIS) {
					 
				
				st.push(c+"");
			 }
			 else if(c==CLOSE_BRACES || c== CLOSE_CURLY_BRACES || c==CLOSE_PARENTESIS) {
				 
				 
				 last_pop = st.pop().charAt(0);
				 
				 if(c == CLOSE_PARENTESIS && (last_pop==OPEN_CURLY_BRACES || last_pop==OPEN_BRACES) )
					 return false;
				 if(c == CLOSE_BRACES && (last_pop==OPEN_CURLY_BRACES || last_pop==OPEN_PARENTESIS) )
					 return false;
				 if(c == CLOSE_CURLY_BRACES && (last_pop==OPEN_BRACES || last_pop==OPEN_PARENTESIS) )
					 return false;
			 }
			 
			 
		 }
		 
		 
		 return true;
		 
	 }
	 
	 
	 public static String reverseString(String s) {

		 int j= s.toCharArray().length-1;
		 for(int i= j; i>=0; i--)
			 s+=s.charAt(i);
		 
		 return s.substring(j+1);
	 }
	 
	 
	 public static boolean hasDuplicates(int[] array) {
		 Map<Integer, Integer> seen = new HashMap<Integer, Integer>();
		 Integer temp=null;
		 for(int value:array) {
			 temp = Integer.valueOf(value);
			 if(seen.get(temp) == null)
				 seen.put(temp, temp);
			 else
				 return true;
					 
		 }
		 
		 return false;
	 }
	 
	 static boolean Has2movies(int fligthLegth, List<Integer> movieLengths) {
		 
		 movieLengths.sort(null);
		 
		 int r=0, f=movieLengths.size() -1;
		 
		 while(r != f && f>0) {
			 
			 
			 if(movieLengths.get(r).intValue() + movieLengths.get(f).intValue() > fligthLegth ) {
				 
				 f--;
			 }
			 else if(movieLengths.get(r).intValue() + movieLengths.get(f).intValue() < fligthLegth ) {
				 
				 r++;
			 }
			 else return true;
			 
			 
		 }
				 
		 
		 return false;
		 
	 }
	 
	 static int[] evalCells(int[] cells, int days ) {
		 
		 int [] newCells = new int[cells.length];
		 
		 for(int n=0; n<days; n++) {
			 for(int i=0; i<cells.length; i++) {
				 if(i==0) {
					 if(cells[i+1] == 0)
						 newCells[i] = 1;
					else
						newCells[i] = 0;
					 
					 continue;
				 }
				
				 if(i==(cells.length - 1)) {
					 if(cells[i-1] == 0)
						 newCells[i] = 1;
					else
						newCells[i] = 0;
					 
					 break;
				 }
				 
				 if(cells[i+1] == cells[i-1])
					 newCells[i] = 1;
				else
					newCells[i] = 0;
				
				 
			 }
			 
			 cells = newCells.clone();
		 
		 }
		 
		 
		 return newCells;
	 }
	 
	

	public static void main(String[] args) {
		
		
		System.out.println("Verify { [ ] ( ) }"+verifyClosing("{[]()}"));
		System.out.println("Verify { [ ( ] ) }"+verifyClosing("{ [ ( ] ) }"));
		System.out.println("Verify { [ }"+verifyClosing("{ [ }"));

		System.out.println("reserver string "+reverseString("arribederchi"));
		int[] sample = {1,10,4,3,5,8,0,9,-100};
		System.out.println("duplicates "+hasDuplicates(sample));
		
		List<Integer> movieLengths = new ArrayList<Integer>();
		
		movieLengths.add(120);
		movieLengths.add(50);
		movieLengths.add(90);
		movieLengths.add(10);
		movieLengths.add(120);
		movieLengths.add(100);
		movieLengths.add(100);
		
		System.out.println("Has 2 movies "+Has2movies(120, movieLengths));
		int [] sampleCells = {1,0,1,1};
		
		for(int c: evalCells(sampleCells, 4))
			System.out.print("Eval cells "+c );

	}

}
