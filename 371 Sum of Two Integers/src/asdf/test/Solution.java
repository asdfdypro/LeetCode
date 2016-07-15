package asdf.test;

/**
 * (数字求和)
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example:
 * <p>
 * Given a = 1 and b = 2, return 3.
 * <p>
 * Created by Asdf on 2016/7/15.
 */
public class Solution {


    public int getSum(int a, int b) {

        int aa,bb,cc=0;
        int pos=1;
        int res=0;
        for (int i = 0; i < 32; i++) {
            aa=a&pos;bb=b&pos;
            res|=aa^bb^cc;
            cc=(aa&bb|aa&cc|bb&cc)<<1;
            pos<<=1;
        }


        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int i=1,j=1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i + j != solution.getSum(i, j))
                    System.out.println(String.format("%d+%d=%d but getSum=%d", i, j, i + j, solution.getSum(i, j)));
                else
                    System.out.println("true");
            }
        }


    }
}
