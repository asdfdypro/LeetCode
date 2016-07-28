package asdf.test;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * (重排飞机票)
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * <p>
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * <p>
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * <p>
 * Given [5, 4, 3, 2, 1],
 * return false.
 */
public class Solution {

    //用两个堆表示
    public boolean increasingTriplet(int[] nums) {
        Queue<Integer> samllStack = new PriorityQueue<>();
        Queue<Integer> midStack = new PriorityQueue<>();

        for (int num :
                nums) {
            if (!samllStack.isEmpty() && num > samllStack.peek()) {
                if (!midStack.isEmpty() && num > midStack.peek()) {
                    return true;
                }
                midStack.offer(num);
            }
            samllStack.offer(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(solution.increasingTriplet(new int[]{1, 1,1}));//false
    }
}

