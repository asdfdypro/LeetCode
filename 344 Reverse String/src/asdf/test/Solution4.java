package asdf.test;

public class Solution4 {

	/**
	 * (翻转字符串) Write a function that takes a string as input and returns the
	 * string reversed.
	 * 
	 * Example: Given s = "hello", return "olleh".
	 */
	// 	3 ms 
	public String reverseString(String s) {
	     char[] word = s.toCharArray();
	        int i = 0;
	        int j = s.length() - 1;
	        while (i < j) {
	            char temp = word[i];
	            word[i] = word[j];
	            word[j] = temp;
	            i++;
	            j--;
	        }
	        return new String(word);
	}

	public static void main(String[] args) {
		Solution4 solution = new Solution4();
		System.out.println(solution.reverseString("hello"));
	}
}
