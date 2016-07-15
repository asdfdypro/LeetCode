package asdf.test;

public class Solution {

	/**
	 * (翻转字符串) Write a function that takes a string as input and returns the
	 * string reversed.
	 * 
	 * Example: Given s = "hello", return "olleh".
	 */
 	//4 ms 
	public String reverseString(String s) {
		StringBuilder res = new StringBuilder(s);
		res.reverse();
		return res.toString();

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverseString("hello"));
	}
}
