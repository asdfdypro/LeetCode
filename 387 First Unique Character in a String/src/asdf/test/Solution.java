package asdf.test;

/**
 * (第一个非重复字符)
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 */
public class Solution {
    public int firstUniqChar(String s) {
        int[] chars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
}