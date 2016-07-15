package asdf.test;

/**
 * Created by Asdf on 2016/7/15.
 */
public class GuessGame {

    private int guessNum;


    public GuessGame(int guessNum) {
        this.guessNum = guessNum;
    }


    /**
     * The guess API is defined in the parent class GuessGame.
     *
     * @param num your guess
     * @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
     */
    protected int guess(int num) {

        return num - guessNum;
    }
}
