package asdf.test;

/**
 * (二叉树小偷)
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * <p>
 * Example 2:
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class Solution2 {

    //搜索 将偷与不偷一次算出来，减少调用 1ms
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null)
            return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);//本节点不偷
        res[1] = root.val + left[0] + right[0];//偷本节点

        return res;
    }


    public static void main(String[] args) {

        Solution2 solution = new Solution2();
        TreeNode root;

        root = TreeNode.createTree(new Integer[]{3, 2, 3, null, 3, null, 1});
        System.out.println(solution.rob(root));

        root = TreeNode.createTree(new Integer[]{3, 4, 5, 1, 3, null, 1});
        System.out.println(solution.rob(root));
    }
}

