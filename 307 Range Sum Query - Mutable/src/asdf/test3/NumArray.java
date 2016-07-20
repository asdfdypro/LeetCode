package asdf.test3;

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
    //树状数组
    private int BIT[];               // Binary Indexed Tree = Fenwick Tree
    private int[] nums;

    public NumArray(int[] nums) {
        BIT = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            init(i + 1, nums[i]);
        }
        this.nums = nums;
    }
    private void init(int i, int val) {
        while(i < BIT.length) {
            BIT[i] += val;
            i = i + (i & -i);
        }
    }

    public void update(int i, int val) {

        int delta = val - nums[i];
        nums[i] = val;
        init(i + 1, delta);
    }

    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }

    private int getSum(int i) {
        int sum = 0;
        while(i > 0) {
            sum += BIT[i];
            i = i - (i & -i);
        }
        return sum;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println();

        numArray = new NumArray(new int[]{9, -8});
        numArray.update(0, 3);
        System.out.println(numArray.sumRange(1, 1));
        System.out.println(numArray.sumRange(0, 1));
        numArray.update(1, -3);
        System.out.println(numArray.sumRange(0, 1));
    }
}