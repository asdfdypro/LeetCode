package asdf.test;

import java.util.*;

/**
 * (出现最多的元素)
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Solution {

    private static Comparator comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o2[0] - o1[0];
        }
    };

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, int[]> numMap = new HashMap<>();

        int[] count;
        for (int num : nums) {
            count = numMap.get(num);
            if (count == null) {
                count = new int[]{1,num};
                numMap.put(num, count);
            } else {
                count[0]++;

            }
        }


        PriorityQueue<int[]> frequent = new PriorityQueue<>(comparator);
        for (int[] c:numMap.values()) {
            frequent.offer(c);
        }

        List<Integer>res=new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(frequent.poll()[1]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res;

        res = solution.topKFrequent(new int[]{1,1,1,2,2,3,4,4,4}, 2);
        System.out.println(Arrays.toString(res.toArray()));

        res = solution.topKFrequent(new int[]{3,0,1,0}, 1);
        System.out.println(Arrays.toString(res.toArray()));


    }
}
