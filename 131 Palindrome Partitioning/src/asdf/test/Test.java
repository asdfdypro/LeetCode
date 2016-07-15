package asdf.test;

import java.util.ArrayList;
import java.util.List;

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

	public static List<List<String>> partition(String s) {

		List<List<String>> f[] = new List[s.length()];// 表示从0到i（含）的分割方法
		boolean g[][] = new boolean[s.length()][s.length()];// 表示从i到j（含）是否为回文串

		for (int i = 0; i < f.length; i++) {
			f[i] = new ArrayList<List<String>>();
			List<String>	list;
			if (isPalindrome(s, g, 0, i)) {
				list=new ArrayList<String>();
				list.add(s.substring(0, i+1));
				f[i].add(list);
			} 
			for (int j = 1; j <= i; j++) {
				if (isPalindrome(s, g, j, i)) {
					for (List<String> l :  f[j - 1]) {
						list=new ArrayList<String>();
						list.addAll(l);						
						list.add(s.substring(j, i+1));
						f[i].add(list);
					}
				}
			}
		}
		return f[f.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(partition("ab").size());

	}

}
