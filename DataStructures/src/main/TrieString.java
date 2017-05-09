package main;

import java.util.HashMap;
import java.util.Map;



public class TrieString {
	class Node {
		Map<String, Node> map;
		boolean endOfWord;

		Node() {
			map = new HashMap<String, Node>();
			endOfWord = false;
		}

	}
	
	Node root;
	
	public TrieString() {
		// TODO Auto-generated constructor stub
		root = new Node();
	}
	public void insert(String word){
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			String s = word.substring(i,i+1);
			if(current.map.containsKey(s)){
				current = current.map.get(s);
			}else{
				Node node = new Node();
				current.map.put(s, node);
				current = node;
			}
		}
	}
}
