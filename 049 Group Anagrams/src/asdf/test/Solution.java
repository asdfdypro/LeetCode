package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (聚合字符串) Given an array of strings, group anagrams together.
	 * 
	 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
	 * 
	 * [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]
	 * 
	 * Note:
	 * 
	 * For the return value, each inner list's elements must follow the
	 * lexicographic order. All inputs will be in lower-case.
	 */

	private void addMap(Map<String, List<String>> resMap, String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		String standard = new String(c);
		List<String> list = resMap.get(standard);
		if (list == null) {
			list = new LinkedList<String>();// !!!使用ArrayList更快！！！！
			resMap.put(standard, list);
		}
		int len = list.size();
		int pos = 0;
		for (; pos < len; pos++) {
			if (list.get(pos).compareTo(s) >= 0)
				break;
		}
		list.add(pos, s);
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> resMap = new HashMap<String, List<String>>();

		for (String s : strs) {
			addMap(resMap, s);
		}

		return new ArrayList<List<String>>(resMap.values());
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		String[] strs = { "" };

		List<List<String>> res = solution.groupAnagrams(strs);

		for (List<String> list : res) {
			for (String string : list) {
				System.out.print(string + " , ");
			}
			System.out.println();
		}
	}

}
