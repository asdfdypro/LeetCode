package asdf.test;

/**
 * (快速计算幂次)
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * <p>
 * Example1:
 * <p>
 * a = 2
 * b = [3]
 * <p>
 * Result: 8
 * <p>
 * Example2:
 * <p>
 * a = 2
 * b = [1,0]
 * <p>
 * Result: 1024
 */
public class Solution {
    //超时
    public int superPow(int a, int[] b) {
        long res = 1;
        int times = (int) Math.pow(10,b.length-1);

        for (int i = 0; i < b.length; i++) {
            for (int k = times; k > 0; k--)
                for (int j = 0; j < b[i]; j++) {
                    res *= a;
                    while (res > 1337)
                        res %= 1337;
                }
            times /= 10;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        for (int i = 0; i < 50; i++) {
//            System.out.println(solution.superPow(2, new int[]{i}));
//        }
//
//        System.out.println(solution.superPow(2, new int[]{1,2,3}));
//        System.out.println(solution.superPow(2, new int[]{123}));

        System.out.println(solution.superPow(2147483647, new int[]{2,0,0}));

    }
}
