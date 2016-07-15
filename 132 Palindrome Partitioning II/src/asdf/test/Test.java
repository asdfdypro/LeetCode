package asdf.test;

public class Test {

	private static boolean isPalindrome(String s, boolean[][] g, int i, int j) {
		boolean res = false;
		if (i == j)
			res = true;
		else if (s.charAt(i) == s.charAt(j)) {
			if (j - i == 1)
				res = true;
			else
				res = g[i + 1][j - 1];
		}
		g[i][j] = res;
		return res;
	}

	public static int minCut(String s) {
		int f[] = new int[s.length()];// 表示从0到i（含）最少的切割次数
		boolean g[][] = new boolean[s.length()][s.length()];// 表示从i到j（含）是否为回文串

		for (int i = 0; i < f.length; i++) {
			int min;
			if (isPalindrome(s, g, 0, i)) {
				min = -1;
			} else {
				min = Integer.MAX_VALUE;
			}
			for (int j = 1; j <= i; j++) {
				if (isPalindrome(s, g, j, i)) {
					if (f[j - 1] < min)
						min = f[j - 1];
				}
			}
			f[i] = min + 1;
		}
		return f[f.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(minCut("aaaaaaaaaab"));

	}

}
