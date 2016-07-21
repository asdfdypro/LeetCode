package asdf.test;

/**
 * (数字求和)
 * Additive number is a string whose digits can form additive sequence.
 * <p>
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * <p>
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * <p>
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * <p>
 * 1 + 99 = 100, 99 + 100 = 199
 * <p>
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p>
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * <p>
 * Follow up:
 * How would you handle overflow for very large input integers?
 */
public class Solution {

    //4 ms
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len < 3 )
            return false;

        long first, s,p,q;
        StringBuilder sb;
        for (int i = 1; i < len - 1; i++) {
            try {
                first = Long.valueOf(num.substring(0, i));
            } catch (NumberFormatException e) {
                break;
            }
            for (int j = i + 1; j < len; j++) {
                try {
                    p = Long.valueOf(num.substring(i, j));
                } catch (NumberFormatException e) {
                    continue;
                }
                sb=new StringBuilder();
                sb.append(first);
                sb.append(p);
                q=first+p;
                while(sb.length()<len){
                    sb.append(q);
                    s=p;
                    p=q;
                    q=s+p;
                }
                if(num.equals(sb.toString()))
                    return  true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAdditiveNumber("112358"));
        System.out.println(solution.isAdditiveNumber("199100199"));
        System.out.println(solution.isAdditiveNumber("198019823962"));
        System.out.println(solution.isAdditiveNumber("011235"));//true
        System.out.println(solution.isAdditiveNumber("0235813"));//false
        System.out.println(solution.isAdditiveNumber("121474836472147483648"));
    }
}
