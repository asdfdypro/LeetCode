package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	/**
	 * (单词变换方法) Given two words (beginWord and endWord), and a dictionary's word
	 * list, find all shortest transformation sequence(s) from beginWord to
	 * endWord, such that:
	 * 
	 * 1.Only one letter can be changed at a time
	 * 
	 * 2.Each intermediate word must exist in the word list
	 * 
	 * For example,
	 * 
	 * Given: beginWord = "hit" endWord = "cog" wordList =
	 * ["hot","dot","dog","lot","log"]
	 * 
	 * Return: [ ["hit","hot","dot","dog","cog"],
	 * ["hit","hot","lot","log","cog"] ]
	 * 
	 * Note: All words have the same length. All words contain only lowercase
	 * alphabetic characters.
	 */
	// 深搜 回朔

	// 剪枝
	// nowRes大于当前最短值时，剪枝
	// 记录单词间距离

	// 超时
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> res = new ArrayList<List<String>>();
		int wordLength = beginWord.length();
		Map<String, Integer> workSign = new HashMap<>(wordList.size());
		List<String> nowRes = new ArrayList<>();
		nowRes.add(beginWord);
		int[] distanceLength = { 0 };
		find(res, distanceLength, endWord, wordLength, wordList, workSign, nowRes, beginWord);
		return res;
	}

	/**
	 * 回朔查询
	 * 
	 * @param res
	 *            结果集
	 * @param endWord
	 *            目标
	 * @param wordList
	 *            词典
	 * @param wordSize
	 *            词典大小
	 * @param workSign
	 *            单词使用记录
	 * @param workRes
	 *            当前结果
	 * @param nowWord
	 *            当前查询单词
	 */
	private void find(List<List<String>> res, int[] distanceLength, String endWord, int wordLength,
			Set<String> wordList, Map<String, Integer> workSign, List<String> nowRes, String nowWord) {

		// 结束
		if (wordDistance(nowWord, endWord, wordLength)) {
			List<String> r = new ArrayList<>(nowRes);
			r.add(endWord);
			int rSize = r.size();
			if (res.size() == 0) {
				res.add(r);
				distanceLength[0] = rSize;
			} else {
				if (distanceLength[0] > rSize) {
					res.clear();
					res.add(r);
					distanceLength[0] = rSize;
				} else if (distanceLength[0] == r.size())
					res.add(r);
			}
			return;
		}

		// 剪枝
		if (distanceLength[0] > 0 && nowRes.size() - distanceLength[0] >= 0)
			return;

		// 搜索
		for (String word : wordList) {
			// 没有使用并且差一个字符
			if (workSign.get(word) == null && wordDistance(word, nowWord, wordLength)) {
				workSign.put(word, 1);
				nowRes.add(word);
				find(res, distanceLength, endWord, wordLength, wordList, workSign, nowRes, word);
				nowRes.remove(word);
				workSign.put(word, null);
			}
		}
	}

	/**
	 * 单词距离
	 */
	private boolean wordDistance(String w1, String w2, int wordLength) {
		int d = 0;
		for (int i = 0; i < wordLength; i++) {
			if (w1.charAt(i) != w2.charAt(i))
				d++;
			if (d > 1)
				return false;
		}
		return d == 1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		// String beginWord = "hot";
		// String endWord = "dog";
		// String[] words = { "hot", "dog" };

		// String beginWord = "hit";
		// String endWord = "cog";
		// String[] words = { "hot", "dot", "dog", "lot", "log" };

//		String beginWord = "red";
//		String endWord = "tax";
//		String[] words = { "ted", "tex", "red", "tax", "tad", "den", "rex", "pee" };

//		 String beginWord = "qa";
//		 String endWord = "sq";
//		 String[] words = { "si", "go", "se", "cm", "so", "ph", "mt", "db",
//		 "mb", "sb", "kr", "ln",
//		 "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to",
//		 "ra", "fa", "yo",
//		 "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn",
//		 "au", "ur", "rh",
//		 "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge",
//		 "th", "pm", "rb",
//		 "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa",
//		 "pi", "os", "uh",
//		 "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn",
//		 "mi", "am", "ex",
//		 "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr",
//		 "sq", "ye" };

		 String beginWord = "cet";
		 String endWord = "ism";
		 String[] words = { "kid", "tag", "pup", "ail", "tun", "woo", "erg",
		 "luz", "brr", "gay",
		 "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal",
		 "bar", "die",
		 "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan",
		 "cot", "bid",
		 "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad",
		 "tut", "sag",
		 "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads",
		 "max", "jaw",
		 "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig",
		 "fie", "toy",
		 "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply",
		 "awe", "pry",
		 "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski",
		 "ova", "wed",
		 "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb",
		 "chi", "sap",
		 "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan",
		 "age", "fax",
		 "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag",
		 "jar", "arm",
		 "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk",
		 "far", "mew",
		 "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy",
		 "nag", "ron",
		 "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy",
		 "sop", "but",
		 "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod",
		 "yam", "pew",
		 "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon",
		 "dog", "bib",
		 "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr",
		 "vie", "nev",
		 "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx",
		 "tar", "kin",
		 "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan",
		 "fey", "bus",
		 "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe",
		 "ion", "six",
		 "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash",
		 "oar", "cap",
		 "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky",
		 "maj", "hue",
		 "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw",
		 "vim", "sec",
		 "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see",
		 "zit", "maw",
		 "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo",
		 "any", "dow",
		 "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao",
		 "aug", "mum",
		 "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem",
		 "who", "bet",
		 "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix",
		 "hep", "fur",
		 "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye",
		 "hop", "haw",
		 "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito",
		 "woe", "our",
		 "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug",
		 "asp", "hui",
		 "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo",
		 "gym", "dug",
		 "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd",
		 "nan", "lay",
		 "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put",
		 "sue", "dim",
		 "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc",
		 "moe", "caw",
		 "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub",
		 "sgt", "lid",
		 "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil",
		 "jig", "hub",
		 "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon",
		 "use", "ban",
		 "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con",
		 "ant", "net",
		 "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow",
		 "sal", "sic",
		 "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job",
		 "wet", "ism",
		 "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego",
		 "mac", "baa",
		 "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal",
		 "tap", "duh",
		 "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han",
		 "met", "hut",
		 "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut",
		 "ala", "ape",
		 "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf",
		 "liz", "ref",
		 "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned",
		 "coo", "win",
		 "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup",
		 "jay", "hob",
		 "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air",
		 "pug", "pox",
		 "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun",
		 "pat", "ten",
		 "mob" };

		Set<String> wordList = new HashSet<>();
		for (String w : words) {
			wordList.add(w);
		}

		List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
		System.out.println(res.size());
		for (List<String> list : res) {
			for (String string : list) {
				System.out.print(string + ",");
			}
			System.out.println();
		}

	}

}
