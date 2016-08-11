package asdf.test;


import java.util.Arrays;


/**
 * (扭动排序)
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * <p>
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * <p>
 * Note:
 * You may assume all input has valid answer.
 * <p>
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class Solution {

    //先找到中位数
    //偶数位放小于中位数的，奇数位放大于中位数的
    public void wiggleSort(int[] nums) {
        if (nums.length < 2)
            return;
        int mid = quickSelectKth(nums, 0, nums.length - 1, nums.length / 2);

        int n=nums.length;
        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            if (nums[newIndex(i,n)] > mid) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < mid) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t=nums[i];nums[i]=nums[j];nums[j]=t;

    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

    /**
     * 选择第K小的数
     *
     * @param k 从0开始
     */
    private int quickSelectKth(int[] nums, int from, int end, int k) {
        int x = nums[from];
        int s = from, t = end;
        while (s < t) {
            while (s < t && nums[t] > x) t--;
            if (s < t) nums[s++] = nums[t];
            while (s < t && nums[s] < x) s++;
            if (s < t) nums[t--] = nums[s];
        }
        nums[s] = x;

        if (s == k)
            return x;
        else if (s < k)
            return quickSelectKth(nums, s + 1, end, k);
        else
            return quickSelectKth(nums, from, s - 1, k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        {
//            int[] num = {2, 1, 3};
//            solution.wiggleSort(num);
//            System.out.println(Arrays.toString(num));
//        }

        {
            int[] num = {1, 3, 2, 2, 3, 1};
            solution.wiggleSort(num);
            System.out.println(Arrays.toString(num));
        }

    }
}
