package asdf.test;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

	/**
	 * (简化路径) Given an absolute path for a file (Unix-style), simplify it.
	 * 
	 * For example,
	 * 
	 * path = "/home/", => "/home"
	 * 
	 * path = "/a/./b/../../c/", => "/c"
	 */

	// 退到根目录再退停止不前
	//多个 //
	public String simplifyPath(String path) {

		String[] pathList = path.split("/");
		Stack<String> s = new Stack<>();
		for (int i = 0; i < pathList.length; i++) {
			if (".".equals(pathList[i])||"".equals(pathList[i]))
				continue;
			else if ("..".equals(pathList[i])) {
				if (!s.empty())
					s.pop();
			} else
				s.push(pathList[i]);
		}
		String res = "";
		for (String p : s) {
			res += "/" + p;
		}
		if ("".equals(res)) {
			res = "/";
		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// System.out.println(solution.simplifyPath("/home/"));
		// System.out.println(solution.simplifyPath("/a/./b/../../c/"));
		// System.out.println(solution.simplifyPath("/aa/./../../.."));

		System.out.println(solution.simplifyPath("/home//foo/"));
	}
}
