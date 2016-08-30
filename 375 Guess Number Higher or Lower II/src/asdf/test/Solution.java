package asdf.test;

/**
 * (最少查询)
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * <p>
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 * <p>
 * Example:
 * <p>
 * n = 10, I pick 8.
 * <p>
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * <p>
 * Game over. 8 is the number I picked.
 * <p>
 * You end up paying $5 + $7 + $9 = $21.
 * <p>
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 * <p>
 * Hint:
 * <p>
 * The best strategy to play the game is to minimize the maximum loss you could possibly face. Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.
 * Take a small example (n = 3). What do you end up paying in the worst case?
 * Check out this article if you're still stuck.
 * The purely recursive implementation of minimax would be worthless for even a small n. You MUST use dynamic programming.
 * As a follow-up, how would you modify your code to solve the problem of minimizing the expected loss, instead of the worst-case loss?
 */
public class Solution {
    //f[i][j]=min(i<k<j){f[i][k-1],f[k+1][j]}+k;
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];


        make(f, 1, n);
        return f[1][n];

    }

    private int make(int[][] f, int i, int j) {
        if (i >= j)
            return 0;
        if (f[i][j] > 0)
            return f[i][j];
        int val = Integer.MAX_VALUE, temp;
        int a, b;
        for (int k = i; k <= j; k++) {
            a = make(f, i, k-1);
            b = make(f, k+1, j);
            temp = (a > b ? a : b) + k;
            if (temp < val)
                val = temp;
        }
        f[i][j] = val;
        return f[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        for (int i = 1; i < 10; i++)
            System.out.println(solution.getMoneyAmount(i));
    }
}