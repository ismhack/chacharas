package com.ismk.basic.examples;

import java.util.ArrayList;
import java.util.List;

public class TreeWords {
	
	private class TreeNode{
		
		int[] children = new int[ALPHABET +1];
		boolean isEnd = false;
		TreeNode nextLevel = null;
		public TreeNode() {
			
			for(int i=0; i<children.length; i++) {
				children[i] = -1;
			}
			children[ALPHABET] = '.' - 'a';
			
		}
		
	}
	
	
	void setUp(List<String> words) {
		
		root = new TreeNode();
		TreeNode crawl = root;
		int index;
		
		for(String word : words) {
			crawl = root;
			for(int i=0; i<word.length(); i++) {
				index = word.charAt(i) - 'a';
				if(crawl.children[index] == -1) {
					crawl.children[index] = index;
				}
				
				if(crawl.nextLevel == null)
				crawl.nextLevel = new TreeNode();
				
				crawl = crawl.nextLevel;
			}
			crawl.isEnd = true;
		}
		
	}
	
	boolean search(String query) {
		
		TreeNode crawl = root;
		int index;
		for(int i=0; i<query.length() && crawl != null; i++) {
			
			index = query.charAt(i) - 'a';
			index = (index > ALPHABET || index < 0) ? ALPHABET : index;
			if(crawl.children[index] >= 0) {
				crawl = crawl.nextLevel;
			} else if(index ==  ALPHABET ) {//dot so skip level
				crawl = crawl.nextLevel;
			}
			else { return false; }
			
		}
		return crawl != null && crawl.isEnd;
	}
	
	final int ALPHABET = 26;
	
	TreeNode root;

	public static void main(String[] args) {

		TreeWords test = new TreeWords();
		List<String> words =  new ArrayList<String>();
		words.add("cat");
		words.add("bat");
		words.add("rat");
		words.add("drat");
		words.add("dart");
		words.add("drab");
		test.setUp(words);
		
		System.out.println("Search word cat "+test.search("cat"));
		System.out.println("Search word bat "+test.search("bat"));
		System.out.println("Search word c.t "+test.search("c.t"));
		System.out.println("Search word .at "+test.search(".at"));
		System.out.println("Search word ..t "+test.search("..t"));
		System.out.println("Search word d..t "+test.search("d..t"));
		System.out.println("Search word dr.. "+test.search("dr.."));
		System.out.println("Search word ... "+test.search("..."));
		System.out.println("Search word ..... "+test.search("....."));
		System.out.println("Search word h.t "+test.search("h.t"));
		System.out.println("Search word c. "+test.search("c."));
		System.out.println("Search word c.. "+test.search("c.."));
		System.out.println("Search word ........ "+test.search("........"));
		
	}

}
