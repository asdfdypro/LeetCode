package asdf.test;

import java.util.Random;

/**
 * (返回随机数组)
 * Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();
 */
public class Solution {
    int[] init;

    public Solution(int[] nums) {
        init=nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return init;
    }

    //通过交换的方式实现
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] random=new int[init.length];
        for (int i = 0; i < random.length; i++) {
            random[i]=i;
        }
        //随机交换！！！
        Random r=new Random();
        for (int i = random.length-1; i >= 0 ; i--) {
            int t=r.nextInt(i+1);
            int swap=random[i];
            random[i]=random[t];
            random[t]=swap;
        }
        for (int i = 0; i < random.length; i++) {
            random[i]=init[random[i]];
        }
        return random;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */