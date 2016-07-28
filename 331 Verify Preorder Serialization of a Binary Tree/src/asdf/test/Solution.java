package asdf.test;


import java.util.Stack;

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
public class Solution {


    //Stack 到叶子节点开始回收
    public boolean isValidSerialization(String preorder) {
        if ("#".equals(preorder))
            return true;

        Stack<Integer> stack = new Stack<>();
        String[] preorderArray=preorder.split(",");
        int num;
        int count=0;
        String node;

        for (int i = 0; i <preorderArray.length; i ++) {
            node=preorderArray[i];
            if ("#".equals(node)) {
                if (stack.isEmpty())
                    return false;
                num = stack.pop();//上层出栈
                while (!stack.isEmpty() && stack.peek() != num) {//上层访问两次后递归出栈
                    num = stack.pop();
                }
                if (stack.isEmpty()&&i+1<preorderArray.length)//只有最后才能为空
                    return false;
            } else {
                stack.push(count);
                stack.push(count);
                count++;
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

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
