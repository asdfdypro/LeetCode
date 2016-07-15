package asdf.test;

/**
 * (实现前缀树 ) Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 */
// 计数表示当前位置有单词
public class Trie {

	private TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
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
		node.count++;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		int wordLen = word.length();
		int nodeChar;
		TrieNode node = this.root;
		for (int i = 0; i < wordLen; i++) {
			nodeChar = word.charAt(i) - 'a';
			if (node.children[nodeChar] == null) {
				return false;
			}
			node = node.children[nodeChar];
		}
		return node.count > 0;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		int wordLen = prefix.length();
		int nodeChar;
		TrieNode node = this.root;
		for (int i = 0; i < wordLen; i++) {
			nodeChar = prefix.charAt(i) - 'a';
			if (node.children[nodeChar] == null) {
				return false;
			}
			node = node.children[nodeChar];
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("aaa"));
		System.out.println(trie.startsWith("aaa"));
		trie.insert("aaa");
		System.out.println(trie.search("aaa"));
		System.out.println(trie.startsWith("aaa"));
		System.out.println(trie.search("aa"));
		System.out.println(trie.startsWith("aa"));
		trie.insert("aa");
		System.out.println(trie.search("aa"));
		System.out.println(trie.startsWith("aa"));

	}

}

class TrieNode {

	public TrieNode[] children;
	public int count;

	public TrieNode() {
		this.children = new TrieNode[26];
		this.count = 0;
	}

}
