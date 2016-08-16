package asdf.test;

/**
 * (倒水)
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 * <p>
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 * <p>
 * Operations allowed:
 * <p>
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * <p>
 * Example 1: (From the famous "Die Hard" example)
 * <p>
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * <p>
 * Example 2:
 * <p>
 * Input: x = 2, y = 6, z = 5
 * Output: False
 */
public class Solution {

    //两个瓶子可能量出的水是两个瓶子容量最大公约数的倍数。所以只要判断z是否可以被x，y的最大公约数整除即可。
    public boolean canMeasureWater(int x, int y, int z) {

        //最后可量的水可以装在一个或者两个罐子内
        if (x+y<z) return false;
        //x或者y为0的情况
        if (x==z || y==z || x+y==z) return true;
        //利用得到的最大公约数
        int n = maxComDiv(x, y);
        if(n==0)
            return z==0;
        return z % n == 0;
    }

    private int maxComDiv(int x,int y){
        int max=Math.max(x,y);
        int min=Math.min(x,y);
        if(min==0)
            return 0;
        int temp;

        while(max%min!=0){
            temp=max-min;
            max=Math.max(temp,min);
            min=Math.min(temp,min);
        }
        return min;
    }

    private int maxComDiv2(int x,int y) {
        int max=Math.max(x,y);
        int min=Math.min(x,y);
        int temp;

        while (min != 0) {
            temp = min;
            min = max % min;
            max = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canMeasureWater(3, 5, 4));//true
        System.out.println(solution.canMeasureWater(2, 6, 5));//false

        System.out.println(solution.canMeasureWater(2, 6, 7));//false
        System.out.println(solution.canMeasureWater(2, 6, 2));//true
        System.out.println(solution.canMeasureWater(2, 6, 6));//true

        System.out.println(solution.canMeasureWater(0, 0, 0));//true
        System.out.println(solution.canMeasureWater(0, 0, 1));//false

        System.out.println(solution.canMeasureWater(1, 2, 3));//true
        System.out.println(solution.canMeasureWater(1, 1, 12));//false
    }

}
