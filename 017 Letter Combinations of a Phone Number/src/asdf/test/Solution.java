package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (数字盘的字符组合)Given a digit string, return all possible letter combinations
	 * that the number could represent.
	 */
	// 回溯+记录

	private static Map<Character, String> numberMap = new HashMap<>();
	static {
		numberMap.put('2', "abc");
		numberMap.put('3', "def");
		numberMap.put('4', "ghi");
		numberMap.put('5', "jkl");
		numberMap.put('6', "mno");
		numberMap.put('7', "pqrs");
		numberMap.put('8', "tuv");
		numberMap.put('9', "wxyz");
	}

	public List<String> letterCombinations(String digits) {
		List<String> res, newRes;
		String addStr;
		int len = digits.length(), lenAddStr;
		res = new ArrayList<String>();
		if (len != 0) {
			res.add("");
			for (int i = 0; i < len; i++) {
				addStr = numberMap.get(digits.charAt(i));
				if (addStr == null) {
					return new ArrayList<>();
				}
				lenAddStr = addStr.length();
				newRes = new ArrayList<>();
				for (int j = 0; j < lenAddStr; j++) {
					for (String s : res) {
						newRes.add(s + addStr.charAt(j));
					}
				}
				res = newRes;
			}
		}
		return res;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		System.out.println(solution.letterCombinations("3123").size());

	}
}