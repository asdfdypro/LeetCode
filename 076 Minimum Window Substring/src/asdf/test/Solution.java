package asdf.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

	/**
	 * (最少覆盖子串) Given a string S and a string T, find the minimum window in S
	 * which will contain all the characters in T in complexity O(n).
	 * 
	 * For example,
	 * 
	 * S = "ADOBECODEBANC"
	 * 
	 * T = "ABC"
	 * 
	 * Minimum window is "BANC".
	 * 
	 * Note: If there is no such window in S that covers all characters in T,
	 * return the empty string "".
	 * 
	 * If there are multiple such windows, you are guaranteed that there will
	 * always be only one unique minimum window in S.
	 * 
	 * Subscribe to see which companies asked this question
	 */
	// 假使[from,to]中存在一组ABC，且from指向A，显然[from,to]中只有一个A
	// 下一个to为B或C，增加分别的记录数目，加入队列中
	// 下一个为A，向后队列出队，记录减一，当为目标数目时，为from，组成新的[from,to]
	//相当于先扩展尾指针，再收缩头指针
	public String minWindow(String s, String t) {

		// 构建目标数组
		Map<Character, Integer> des = new HashMap<Character, Integer>();
		int tLen = t.length();
		Integer num;
		for (int i = 0; i < tLen; i++) {
			num = des.get(t.charAt(i));
			if (num == null)
				des.put(t.charAt(i), 1);
			else
				des.put(t.charAt(i), num + 1);
		}

		int minLen = Integer.MAX_VALUE;
		int minFrom = 0, minTo = 0, from = -1, to;
		char fromc;
		int tNum = 0;// 拥有的t字符串数目
		Map<Character, Integer> workMap = new HashMap<Character, Integer>();
		Queue<Integer> workQueue = new LinkedList<>();
		Integer workNum;
		char c;

		int sLen = s.length();
		for (to = 0; to < sLen; to++) {
			c = s.charAt(to);
			num = des.get(c);
			if (num != null) {// 关键字符

				workNum = workMap.get(c);
				if (workNum == null) {
					workNum = 1;
					workMap.put(c, 1);
				} else
					workMap.put(c, ++workNum);

				if (workNum <= num) {// 小于目标数目，t字符串数目增加
					tNum++;
				}

				if (from == -1) {// 首个位置
					from = to;
				} else {
					workQueue.offer(to);
					fromc= s.charAt(from);
					if (workNum > num && c == fromc) {// 首元素相同
						//重新选择首元素
						workNum = workMap.get(fromc);
						num = des.get(fromc);
						while (workNum > num) {
							workMap.put(fromc, workNum - 1);
							from = workQueue.poll();
							fromc= s.charAt(from);
							workNum = workMap.get(fromc);
							num = des.get(fromc);
						}
						
					}
				}

				if (tNum >= tLen) {// 序列完整
					if (minLen > to - from) {
						minLen = to - from;
						minFrom = from;
						minTo = to;
					}
				}

			}
		}

		if (minLen == Integer.MAX_VALUE)
			return "";
		else
			return s.substring(minFrom, minTo + 1);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.minWindow("", ""));
		System.out.println(solution.minWindow("a", ""));
		System.out.println(solution.minWindow("a", "a"));
		System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
	}
}
