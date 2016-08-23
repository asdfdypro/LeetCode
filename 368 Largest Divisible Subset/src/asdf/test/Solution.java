package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (最大可除子序列)
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1:
 * <p>
 * nums: [1,2,3]
 * <p>
 * Result: [1,2] (of course, [1,3] will also be ok)
 * <p>
 * Example 2:
 * <p>
 * nums: [1,2,4,8]
 * <p>
 * Result: [1,2,4,8]
 */
public class Solution {


    //c1<c2<c3<....<ck 相互能整除,若ci能整除ck，则ci能整除所有c

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums.length < 1)
            return res;

        Arrays.sort(nums);
        int f[] = new int[nums.length];
        int pos[] = new int[nums.length];
        int max = 0, maxPos = -1;

        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            pos[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && f[j] >= f[i]) {
                    f[i] = f[j] + 1;
                    pos[i] = j;
                }
            }
            if (f[i] > max) {
                max = f[i];
                maxPos = i;
            }
        }
        while (maxPos != -1) {
            res.add(nums[maxPos]);
            maxPos = pos[maxPos];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.largestDivisibleSubset(new int[]{1}).toArray()));
        System.out.println(Arrays.toString(solution.largestDivisibleSubset(new int[]{1, 2}).toArray()));
        System.out.println(Arrays.toString(solution.largestDivisibleSubset(new int[]{1, 2, 3}).toArray()));
        System.out.println(Arrays.toString(solution.largestDivisibleSubset(new int[]{1, 2, 6,4,8}).toArray()));

    }
}
