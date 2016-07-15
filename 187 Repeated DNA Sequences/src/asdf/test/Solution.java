package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	/**
	 * (重复的DNA序列 ) All DNA is composed of a series of nucleotides abbreviated as
	 * A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is
	 * sometimes useful to identify repeated sequences within the DNA.
	 * 
	 * Write a function to find all the 10-letter-long sequences (substrings)
	 * that occur more than once in a DNA molecule.
	 * 
	 * For example,
	 * 
	 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",注意第一段连续的C是5个，第二段连续的C是6个。
	 * 
	 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
	 */

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		int len = s.length();
		if (len <= 10)
			return res;
		Set<Integer> set = new HashSet<>();
		Set<Integer>resSet=new HashSet<>();
		int t=0;
		for (int i = 0; i < 10; i++) {
			t=(t<<2)+nucleotidesToInt(s.charAt(i));
		}
		set.add(t);
		for (int i = 10; i < len; i++) {
			t=(t<<2&1048575) +nucleotidesToInt(s.charAt(i));
			if (set.contains(t)) {
				resSet.add(t);
			}
			set.add(t);
		}
		for (Integer integer : resSet) {
			res.add(intToDNA(integer));
		}
		return res;
	}

	public int nucleotidesToInt(char c) {
		switch (c) {
		case 'A':
			return 0;
		case 'G':
			return 1;
		case 'C':
			return 2;
		case 'T':
			return 3;
		default:
			return 0;
		}
	}

	public String intToDNA(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			switch (n % 4) {
			case 0:
				sb.insert(0, 'A');
				break;
			case 1:
				sb.insert(0, 'G');
				break;
			case 2:
				sb.insert(0, 'C');
				break;
			case 3:
				sb.insert(0, 'T');
				break;
			default:
				break;
			}
			n /= 4;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		List<String> res = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");

		List<String> res = solution.findRepeatedDnaSequences("AAAAAAAAAAAA");
		for (String string : res) {
			System.out.println(string);
		}

	}
}
