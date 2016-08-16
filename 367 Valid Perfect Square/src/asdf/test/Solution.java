package asdf.test;

/**
 * (判断完全平方数)
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Returns: True
 * <p>
 * Example 2:
 * <p>
 * Input: 14
 * Returns: False
 */
public class Solution {

    public boolean isPerfectSquare(int num) {
        if (num == 0)
            return false;

        int last = num % 10;
        if (last == 2 || last == 3 || last == 7 || last == 8)
            return false;

        long s = 0, t = num;
        long mid, midSqr;
        while (s <= t) {
            mid = (t - s) / 2 + s;
            midSqr = mid * mid;
            if (midSqr > num) {
                t = mid - 1;
            } else if (midSqr < num) {
                s = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        System.out.println(solution.isPerfectSquare(808201));//溢出
    }
}
