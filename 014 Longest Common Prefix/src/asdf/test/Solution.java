package asdf.test;

public class Solution {

	/**
	 * (最长公共子前缀)Write a function to find the longest common prefix string
	 * amongst an array of strings.
	 */
	//减少字符串length()的调用次数，减少1ms
	//采用StringBuffer，增加了1ms
	//比较每个的每一位

	public String longestCommonPrefix(String[] strs) {
		if (strs.length < 1)
			return "";

		int[]length=new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			length[i]=strs[i].length();
		}

		StringBuffer prefix = new StringBuffer();

		boolean iscontinue = true;
		int pos = 0;
		char c;
		while (iscontinue) {
			if (pos == length[0]) {
				iscontinue = false;
			} else {
				c = strs[0].charAt(pos);
		
				for (int i = 1; i < strs.length; i++) {
					if (pos == length[i]|| c != strs[i].charAt(pos)) {
						iscontinue = false;
						break;
					}
				}
				if (iscontinue) {
					prefix.append(c);
					pos++;
				}
			}
		}

		return prefix.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] a = { "aaabdd", "aaab" };
		String[] b = {};

		System.out.println(solution.longestCommonPrefix(b));
		System.out.println(solution.longestCommonPrefix(a));
	}
}