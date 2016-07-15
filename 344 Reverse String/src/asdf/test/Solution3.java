package asdf.test;

public class Solution3 {

	/**
	 * (翻转字符串) Write a function that takes a string as input and returns the
	 * string reversed.
	 * 
	 * Example: Given s = "hello", return "olleh".
	 */
	// out
	public String reverseString(String s) {
		String res = new String();
		for (int i = s.length() - 1; i >= 0; i--) {
			res+=s.charAt(i);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		System.out.println(solution.reverseString("hello"));
	}
}
