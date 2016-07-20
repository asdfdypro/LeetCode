package asdf.test;

import java.util.Arrays;

/**
 * (可更新的序列和)Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * <p>
 * Example:
 * <p>
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * <p>
 * Note:
 * <p>
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class NumArray {

    //每次更新所有超时
    private int[] sum;
    private int[] nums;

    public NumArray(int[] nums) {
        if (nums.length == 0)
            return;

        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        this.nums = nums;

    }

    void update(int i, int val) {
        if (sum == null)
            return;

        int update = val - nums[i];
        nums[i] = val;
        for (int j = i; j < this.sum.length; j++) {
            sum[j] += update;
        }


    }

    public int sumRange(int i, int j) {
        if (sum == null)
            return 0;

        if (i > 0)
            return sum[j] - sum[i-1];
        else return sum[j];
    }


    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println();

        numArray = new NumArray(new int[]{9,-8});
        numArray.update(0,3);
        System.out.println(numArray.sumRange(1,1));
        System.out.println(numArray.sumRange(0, 1));
        numArray.update(1,-3);
        System.out.println(numArray.sumRange(0, 1));
    }
}