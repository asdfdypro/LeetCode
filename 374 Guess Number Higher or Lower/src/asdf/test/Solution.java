package asdf.test;

/**
 * (猜数字游戏)
 * <p>
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * <p>
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * <p>
 * Example:
 * <p>
 * n = 10, I pick 6.
 * <p>
 * Return 6.
 */
public class Solution extends GuessGame {
    public Solution(int guessNum) {
        super(guessNum);
    }

    public int guessNumber(int n) {
        int low = 0, high = n + 1;//MAX会溢出
        int mid, t;
        do {
//            mid = (low + high) / 2;
            mid =(high-low) / 2 + low;//防止溢出
            t = guess(mid);
            if (t < 0)
                low = mid;
            else if (t > 0)
                high = mid;
            else
                break;
        } while (low <= high);
        return mid;

    }

    public static void main(String[] args) {
        Solution solution = new Solution(1);
        System.out.println(solution.guessNumber(100));
        solution = new Solution(2);
        System.out.println(solution.guessNumber(100));
        solution = new Solution(100);
        System.out.println(solution.guessNumber(100));
        solution = new Solution(6);
        System.out.println(solution.guessNumber(10));
        solution = new Solution(51);
        System.out.println(solution.guessNumber(100));




    }
}
