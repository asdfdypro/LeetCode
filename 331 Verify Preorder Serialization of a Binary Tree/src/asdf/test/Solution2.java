package asdf.test;


/**
 * (证明树的先序正确)
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * <p>
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * <p>
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p>
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * <p>
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 * <p>
 * Example 2:
 * "1,#"
 * Return false
 * <p>
 * Example 3:
 * "9,#,#,1"
 * Return false
 */
public class Solution2 {


    //Stack 到叶子节点开始回收
    //简化实现
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;//至少一个
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(solution.isValidSerialization("1,#"));
        System.out.println(solution.isValidSerialization("9,#,#,1"));
        System.out.println(solution.isValidSerialization("9,3,4,#,#,#,#"));
        System.out.println(solution.isValidSerialization("#"));//true
        System.out.println(solution.isValidSerialization("9,#,92,#,#"));//true
        System.out.println(solution.isValidSerialization("9,9,#,#,9,#,#"));//true
        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#"));//false
    }


}
