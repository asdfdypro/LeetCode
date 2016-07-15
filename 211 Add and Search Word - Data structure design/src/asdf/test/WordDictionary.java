package asdf.test;

/**
 * (实现前缀树 ) Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 */
// 计数表示当前位置有单词
public class WordDictionary {

	private TrieNode root;

	public WordDictionary() {
		this.root = new TrieNode();
	}

	// Adds a word into the data structure.
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
		node.count++;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return search(root, word, word.length(), 0);
	}

	private boolean search(TrieNode root, String word, int wordLen, int pos) {
		if (root == null)
			return false;
		if (pos == wordLen)
			return root.count > 0;

		char c = word.charAt(pos);
		if (c == '.') {
			for (int i = 0; i < 26; i++) {
				if (search(root.children[i], word, wordLen, pos + 1))
					return true;
			}
			return false;
		} else {
			return search(root.children[c - 'a'], word, wordLen, pos + 1);
		}
	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad"));
		System.out.println(wordDictionary.search("bad"));
		System.out.println(wordDictionary.search(".ad"));
		System.out.println(wordDictionary.search("b.."));

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
