package asdf.test;

/**
 * (不同字符串最大长度)
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * <p>
 * Example 1:
 * <p>
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * <p>
 * Example 2:
 * <p>
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 * <p>
 * Example 3:
 * <p>
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 */
public class Solution {

    public int maxProduct(String[] words) {
        int[] bit = new int[words.length];
        int[] len = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            len[i] = words[i].length();
            for (int j = 0; j < len[i]; j++) {
                bit[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int max = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bit[i] & bit[j]) == 0)
                    if (len[i] * len[j] > max)
                        max = len[i] * len[j];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new String[]{}));
        System.out.println(solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(solution.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(solution.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }
}
