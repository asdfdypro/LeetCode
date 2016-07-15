package asdf.test;

public class Solution {

	/**
	 * 最长回文子串 Given a string S, find the longest palindromic substring in S. You
	 * may assume that the maximum length of S is 1000, and there exists one
	 * unique longest palindromic
	 */
	// 同最少切割次数，记录最长长度
	// 回文串性质利用，判断回文串时间为O(1)
	// 超时，考虑不断剪枝，减少不必要的检查，每增加一个字母，其实只考虑含有最后一个字母的子串是否是回文串即可
	// 变成两层循环解决问题，关键在于回文串中的记录
	// 反向搜索，每次减少一个字母查询
	// 在检查回文串过程中剪枝
	// 将递归改循环
	//超时，尝试方法2
	public String longestPalindrome(String s) {
		if (s.length() == 0)
			return "";

		Boolean[][] g = new Boolean[s.length()][s.length()];// 从i到j是否为回文传

		// 取最极端结果
		int max = 0;
		int maxPos0 = 0;
		int maxPos1 = 1;

		int a, b;
		boolean res;

		for (int j = s.length() - 1; j >= max; j--) {
			for (int i = 0; i <= j - max; i++) {
				// 判断从i到j是否是回文串,含i,j
				a = i;
				b = j;
				do {
					res = false;
					if (a == b)
						res = true;
					else if (s.charAt(a) == s.charAt(b)) {
						if (b - a == 1)
							res = true;
						else if (g[a + 1][b - 1] == null) {
							a++;
							b--;
							continue;
						} else {
							res = g[a + 1][b - 1];
						}
					}
					g[a][b] = res;
					if (res && b - a > max) {// 剪枝
						max =b - a;
						maxPos0 = a;
						maxPos1 = b + 1;
					}
					a--;b++;
				} while (a != i-1);

			}
		}
		return s.substring(maxPos0, maxPos1);

	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.longestPalindrome("a"));
		// System.out.println("aaa".substring(0, 2));

	}
}