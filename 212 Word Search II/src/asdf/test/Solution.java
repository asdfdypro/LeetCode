package asdf.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	/**
	 * (搜索单词) Given a 2D board and a list of words from the dictionary, find all
	 * words in the board.
	 * 
	 * Each word must be constructed from letters of sequentially adjacent cell,
	 * where "adjacent" cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once in a word.
	 * 
	 * For example, Given words = ["oath","pea","eat","rain"] and board =
	 * 
	 * [ ['o','a','a','n'], ['e','t','a','e'], ['i','h','k','r'],
	 * ['i','f','l','v'] ]
	 * 
	 * Return ["eat","oath"].
	 * 
	 * You may assume that all inputs are consist of lowercase letters a-z.
	 * 
	 * You would need to optimize your backtracking to pass the larger test.
	 * Could you stop backtracking earlier?
	 * 
	 * If the current candidate does not exist in all words' prefix, you could
	 * stop backtracking immediately. What kind of data structure could answer
	 * such query efficiently? Does a hash table work? Why or why not? How about
	 * a Trie? If you would like to learn how to implement a basic trie, please
	 * work on this problem: Implement Trie (Prefix Tree) first.
	 */
	// 所有待选词组成字母树，相当于原先的单词
	// 走棋盘
	private char[][] board;
	private TrieNode root;
	private boolean[][] isUse;
	private int wordCount;
	private Set<String> res;//防止重复

	private void search(int i, int j, TrieNode now) {
		if (this.wordCount == 0)
			return;

		now = now.children[board[i][j] - 'a'];
		if (now != null) {
			if (now.word != null) {// 是个单词
				if (!res.contains(now.word))
					this.wordCount--;
				res.add(now.word);
			}
			isUse[i][j] = true;
			if (i > 0 && !isUse[i - 1][j])
				search(i - 1, j, now);
			if (j > 0 && !isUse[i][j - 1])
				search(i, j - 1, now);
			if (i < board.length - 1 && !isUse[i + 1][j])
				search(i + 1, j, now);
			if (j < board[0].length - 1 && !isUse[i][j + 1])
				search(i, j + 1, now);
			isUse[i][j] = false;
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		this.board = board;
		this.root = new TrieNode();
		this.isUse = new boolean[board.length][board[0].length];
		this.res = new HashSet<>();
		for (String word : words) {
			addWord(word);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				search(i, j, this.root);
			}
		}
		return new ArrayList<>(this.res);
	}

	public void addWord(String word) {
		int wordLen = word.length();
		int nodeChar;
		TrieNode node = this.root;
		for (int i = 0; i < wordLen; i++) {
			nodeChar = word.charAt(i) - 'a';
			if (node.children[nodeChar] == null) {
				node.children[nodeChar] = new TrieNode();
			}
			node = node.children[nodeChar];
		}
		if (node.word == null)
			this.wordCount++;
		node.word = word;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
		List<String> res = solution.findWords(board, words);
		for (String string : res) {
			System.out.println(string);
		}
	}
}

class TrieNode {

	public TrieNode[] children;
	public String word;

	public TrieNode() {
		this.children = new TrieNode[26];
		this.word = null;
	}

}
