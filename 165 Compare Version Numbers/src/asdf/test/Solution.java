package asdf.test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * (版本号比较 )Compare two version numbers version1 and version2. If version1 >
	 * version2 return 1, if version1 < version2 return -1, otherwise return 0.
	 * 
	 * You may assume that the version strings are non-empty and contain only
	 * digits and the . character. The . character does not represent a decimal
	 * point and is used to separate number sequences. For instance, 2.5 is not
	 * "two and a half" or "half way to version three", it is the fifth
	 * second-level revision of the second first-level revision.
	 * 
	 * Here is an example of version numbers ordering:
	 * 
	 * 0.1 < 1.1 < 1.2 < 13.37
	 */

	// 末尾的处理
	// 相等的处理

	public int compareVersion(String version1, String version2) {
		int pos1 = 0, pos2 = 0;
		int len1 = version1.length(), len2 = version2.length();
		int end1, end2;
		int v1, v2;
		while (pos1 < len1 && pos2 < len2) {
			end1 = version1.indexOf('.', pos1);
			end2 = version2.indexOf('.', pos2);
			if (end1 < 0)
				end1 = len1;
			if (end2 < 0)
				end2 = len2;
			v1 = Integer.valueOf(version1.substring(pos1, end1));
			v2 = Integer.valueOf(version2.substring(pos2, end2));
			if (v1 > v2)
				return 1;
			else if (v1 < v2)
				return -1;
			else {
				pos1 = end1 + 1;
				pos2 = end2 + 1;
			}
		}
		//末尾处理
		while (pos1 < len1) {
			end1 = version1.indexOf('.', pos1);
			if (end1 < 0)
				end1 = len1;
			v1 = Integer.valueOf(version1.substring(pos1, end1));
			if (v1 > 0)
				return 1;
			pos1 = end1 + 1;
		}
		while (pos2 < len2) {
			end2 = version2.indexOf('.', pos2);
			if (end2 < 0)
				end2 = len2;
			v2 = Integer.valueOf(version2.substring(pos2, end2));
			if (v2 > 0)
				return -1;
			pos2 = end2 + 1;
		}
		return 0;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.compareVersion("0.0.1", "0"));
		System.out.println(solution.compareVersion("0.1", "1.1"));
		System.out.println(solution.compareVersion("0.1", "0.1"));
		System.out.println(solution.compareVersion("0.1", "0.0.1"));
		System.out.println(solution.compareVersion("0.1", "0.1.0"));
	}
}
