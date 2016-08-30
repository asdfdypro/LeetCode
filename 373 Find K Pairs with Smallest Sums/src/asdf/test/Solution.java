package asdf.test;

import java.util.*;

/**
 * (最小数对)
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * <p>
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * <p>
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * <p>
 * Example 1:
 * <p>
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 * <p>
 * Return: [1,2],[1,4],[1,6]
 * <p>
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * <p>
 * Example 2:
 * <p>
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 * <p>
 * Return: [1,1],[1,1]
 * <p>
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * <p>
 * Example 3:
 * <p>
 * Given nums1 = [1,2], nums2 = [3],  k = 3
 * <p>
 * Return: [1,3],[2,3]
 * <p>
 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]
 */
public class Solution {

    class Com implements Comparator<int[]> {

        private int[] nums1, nums2;

        public Com(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
        }

        @Override
        public int compare(int[] o1, int[] o2) {
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        }
    }


    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();

        if(nums1.length==0||nums2.length==0)
            return  res;

        Queue<int[]> queue = new PriorityQueue<int[]>(nums1.length +k, new Com(nums1, nums2));

        for (int i = 0; i < nums1.length; i++) {
            queue.offer(new int[]{i, 0});
        }

        int[] node;
        while (!queue.isEmpty() && k-- > 0) {
            node = queue.poll();
            if (node[1] + 1 < nums2.length)
                queue.offer(new int[]{node[0], node[1] + 1});
            node[0] = nums1[node[0]];
            node[1] = nums2[node[1]];
            res.add(node);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<int[]> res;

        res = solution.kSmallestPairs(new int[]{}, new int[]{}, 3);
        for (int[] n : res) {
            System.out.print(Arrays.toString(n));
        }
        System.out.println();

        res = solution.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3);
        for (int[] n : res) {
            System.out.print(Arrays.toString(n));
        }
        System.out.println();

        res = solution.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
        for (int[] n : res) {
            System.out.print(Arrays.toString(n));
        }
        System.out.println();

        res = solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        for (int[] n : res) {
            System.out.print(Arrays.toString(n));
        }
        System.out.println();


    }


}
