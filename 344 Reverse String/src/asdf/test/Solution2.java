package asdf.test;

public class Solution2 {

	/**
	 * (翻转字符串) Write a function that takes a string as input and returns the
	 * string reversed.
	 * 
	 * Example: Given s = "hello", return "olleh".
	 */
	// 6 ms 
	public String reverseString(String s) {
		StringBuilder res = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			res.append(s.charAt(i));
		}
		return res.toString();
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.reverseString("hello"));
	}
}
