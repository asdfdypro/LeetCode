package asdf.test;

public class Solution {

	/**
	 * (最长不重复子串长度)Given a string, find the length of the longest substring
	 * without repeating characters. For example, the longest substring without
	 * repeating letters for "abcabcbb" is "abc", which the length is 3. For
	 * "bbbbb" the longest substring is "b", with the length of 1.
	 */
	//通过hash的方式记录每个字符上一次出现的位置
	//任意两个重复之间的字符串为不重复的记录
	public int lengthOfLongestSubstring(String s) {

		int max = Integer.MIN_VALUE;
		int prepos = -1;// 前一个重复位置
		int[] numspos = new int[128];// 字母hash

		for (int i = 0; i < 128; i++) {
			numspos[i] = -1;
		}

		int slength = s.length();
		int pos;
		for (int i = 0; i < slength; i++) {
			pos = s.charAt(i);

			if (numspos[pos] > prepos) {
				if (i - prepos > max)
					max = i - prepos;
				prepos = numspos[pos];
			}
			numspos[pos] = i;
		}

		if (s.length() - prepos > max)
			max = s.length() - prepos;

		return max - 1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring("abca"));
	}
}