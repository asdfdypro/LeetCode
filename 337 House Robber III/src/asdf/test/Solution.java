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
public class Solution {

//搜索1252ms
    public int rob(TreeNode root) {
        return rob(root, true);
    }

    private int rob(TreeNode root, boolean canRob) {
        if (root == null)
            return 0;
        //不偷
        int max = rob(root.left, true) + rob(root.right, true);

        if (canRob) {//偷
            int t = rob(root.left, false) +
                    rob(root.right, false) +
                    root.val;
            if (t > max)
                max = t;
        }
        return max;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        TreeNode root;

        root = TreeNode.createTree(new Integer[]{3, 2, 3, null, 3, null, 1});
        System.out.println(solution.rob(root));

        root = TreeNode.createTree(new Integer[]{3, 4, 5, 1, 3, null, 1});
        System.out.println(solution.rob(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode createTree(Integer[] vals) {
        if (vals.length < 1)
            return null;
        TreeNode[] nodes = new TreeNode[vals.length];
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] != null)
                nodes[i] = new TreeNode(vals[i]);
        }
        for (int i = 0; i < vals.length; i++) {
            if (2 * i + 1 < vals.length)
                nodes[i].left = nodes[2 * i + 1];
            if (2 * i + 2 < vals.length)
                nodes[i].right = nodes[2 * i + 2];
        }
        return nodes[0];
    }

    public void print() {
        print(this);
        System.out.println();
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }

        print(root.left);
        System.out.print(root.val + "\t");
        print(root.right);
    }

}