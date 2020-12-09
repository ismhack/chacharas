package com.ismk.basic.examples;

public class TrieExamples {

	public static void main(String[] args) {

		Trie root = new Trie(false);
		add(root, "car".toCharArray());
		add(root, "caw".toCharArray());
		add(root, "cauw".toCharArray());
		add(root, "cuw".toCharArray());
		add(root, "cawuaw".toCharArray());
		add(root, "camarw".toCharArray());

		match(root, "*rw".toCharArray(), 0, "", false);

	}

	// caw, c*w
	public static void match(Trie trie, char[] carr, int index, String str, boolean leaf) {

		if (index == carr.length) {
			if (leaf)
				System.out.println(str);
			return;
		}

		char c = carr[index];
		if (c == '*') {
			Trie[] next = trie.next;
			for (int i = 0; i < 26; i++) {
				if (next[i] != null) {
					match(next[i], carr, index + 1, str + (char)(i + 'a'), trie.leaf);
					match(next[i], carr, index, str + (char)(i + 'a'), trie.leaf);
				}
			}
		} else if (trie.next[c - 'a'] == null) {
			return;
		} else {
			match(trie.next[c - 'a'], carr, index + 1, str + carr[index], trie.leaf);
		}

	}

	// car
	public static void add(Trie trie, char[] carr) {
		int n = carr.length;
		for (int i = 0; i < n; i++) {
			if (trie.next[carr[i] - 'a'] == null) {
				Trie node = new Trie(false);
				trie.next[carr[i] - 'a'] = node;
				if (i == n - 2)
					node.leaf = true;
			}
			trie = trie.next[carr[i] - 'a'];
		}
	}

	static class Trie {

		Trie[] next = new Trie[26];
		boolean leaf;

		public Trie(boolean leaf) {
			this.leaf = leaf;
		}
	}
	
}
