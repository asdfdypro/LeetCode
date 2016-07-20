package asdf.test2;

import java.util.ArrayList;
import java.util.List;

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
    //线段树
    class SegmentTreeNode {
        public int begin;
        public int end;
        public int sum;
        public SegmentTreeNode left;
        public SegmentTreeNode right;


        public SegmentTreeNode(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    private SegmentTreeNode root;

    public NumArray(int[] nums) {
        root = create(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode create(int[] nums, int begin, int end) {
        SegmentTreeNode root = null;
        if (begin == end) {
            root = new SegmentTreeNode(begin, end);
            root.sum = nums[begin];
        } else if (begin < end) {
            int mid = (end - begin) / 2 + begin;
            root = new SegmentTreeNode(begin, end);
            root.left = create(nums, begin, mid);
            root.right = create(nums, mid + 1, end);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }


    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode root, int i, int val) {
        if (root.begin == i && root.end == i) {
            root.sum = val;
            return;
        }

        int mid = (root.end - root.begin) / 2 + root.begin;
        if (mid < i) {
            update(root.right, i, val);
        } else {
            update(root.left, i, val);
        }
        root.sum = root.left.sum + root.right.sum;

    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode root, int i, int j) {
        if (root.begin == i && root.end == j)
            return root.sum;
        else {
            int mid = (root.end - root.begin) / 2 + root.begin;
            if (mid < i) {
                return sumRange(root.right, i, j);
            } else if (mid >= j) {
                return sumRange(root.left, i, j);
            } else {
                return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
            }
        }
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