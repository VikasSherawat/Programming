package main;

import java.io.*;
import java.util.*;


public class Trie {

	class TNode {
		Map<Character, TNode> map;
		boolean endOfWord;
		int words;

		TNode() {
			map = new HashMap<Character, Trie.TNode>();
			endOfWord = false;
			words = 1;
		}

	}

	TNode root;

	public Trie() {
		root = new TNode();
	}

	public boolean insert(String word) {
		TNode current = root;
		for (int i = 0; i < word.length(); i++) {
			if (current.map.containsKey(word.charAt(i))) {
				current = current.map.get(word.charAt(i));
				current.words = current.words + 1;
				if(current.endOfWord)
					return false;
			} else {
				TNode node = new TNode();
				current.map.put(word.charAt(i), node);
				current = node;
			}
		}
		current.endOfWord = true;
		return true;
	}

	public boolean containsPrefix(String prefix) {

		TNode current = root;
		for (int i = 0; i < prefix.length(); i++) {
			if (current.map.containsKey(prefix.charAt(i))) {
				current = current.map.get(prefix.charAt(i));
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean containsWord(String word) {
		TNode current = root;
		for (int i = 0; i < word.length(); i++) {
			if (current.map.containsKey(word.charAt(i))) {
				current = current.map.get(word.charAt(i));
			} else {
				return false;
			}
		}

		return current.endOfWord;
	}

	public void delete(String word) {
		delete(root, word, 0);
	}

	private boolean delete(TNode current, String word, int index) {
		if (index == word.length()) {
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			return current.map.size() == 0;
		}

		char ch = word.charAt(index);
		TNode node = current.map.get(ch);
		if (node == null) {
			return false;
		}

		boolean canDelete = delete(node, word, index + 1);
		if (canDelete) {
			current.map.remove(ch);
			return current.map.size() == 0;
		}
		return false;
	}

	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		Trie trie = new Trie();
		String ADD = "add";
		while (T-- > 0) {
			String word = in.next();
			if(!trie.insert(word)){
				System.out.println("BAD SET\n"+word);
				return;
			}
		}
		

		System.out.println("GOOD SET");
	}

	private int countWordsWithPrefix(String prefix) {
		// TODO Auto-generated method stub
		TNode current = root;
		for (int i = 0; i < prefix.length(); i++) {
			if (current.map.containsKey(prefix.charAt(i))) {
				current = current.map.get(prefix.charAt(i));
			} else {
				return 0;
			}
		}
		return current.words;
	}

	
}
