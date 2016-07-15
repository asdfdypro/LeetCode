package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {

	/**
	 * (二叉树中的最近公共祖先) Given a binary tree, find the lowest common ancestor (LCA)
	 * of two given nodes in the tree.
	 * 
	 * According to the definition of LCA on Wikipedia: “The lowest common
	 * ancestor is defined between two nodes v and w as the lowest node in T
	 * that has both v and w as descendants (where we allow a node to be a
	 * descendant of itself).”
	 */

	/**
	 * 情况1：二叉树是个二叉查找树，且root和两个节点的值(a, b)已知。
	 * 
	 * 
	 * 基本思想为：从树根开始，该节点的值为t，如果t大于t1和t2，说明t1和t2都位于t的左侧，所以它们的共同祖先必定在t的左子树中，从t.
	 * left开始搜索；如果t小于t1和t2，说明t1和t2都位于t的右侧，那么从t.right开始搜索；如果t1<=t<=
	 * t2，说明t1和t2位于t的两侧（或t=t1，或t=t2），那么该节点t为公共祖先。
	 * 
	 */

	/**
	 * 情况2：普通二叉树，root未知，但是每个节点都有parent指针。
	 * 
	 * 基本思想：分别从给定的两个节点出发上溯到根节点，形成两条相交的链表，问题转化为求这两个相交链表的第一个交点，即传统方法：求出linkedList
	 * A的长度lengthA， linkedList
	 * B的长度LengthB。然后让长的那个链表走过abs(lengthA-lengthB)步之后，齐头并进，就能解决了。
	 * 
	 */

	/**
	 * 情况3：也是最普通的情况，二叉树是普通的二叉树，节点只有left/right，没有parent指针。
	 * 
	 * 基本思想：记录从根找到node1和node2的路径，然后再把它们的路径用类似的情况一来做分析，比如还是node1=3,node2=8这个case.
	 * 我们肯定可以从根节点开始找到3这个节点
	 * ，同时记录下路径3,4,6,10，类似的我们也可以找到8,6,10。我们把这样的信息存储到两个vector里面
	 * ，把长的vector开始的多余节点3扔掉，从相同剩余长度开始比较，4!=8, 6==6,我们找到了我们的答案。
	 * 
	 */

	// 全遍历
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		Integer[] vals = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
		TreeNode root = TreeNode.createTree(vals);
		System.out.println(solution.lowestCommonAncestor(root, root.nodes[1], root.nodes[2]).val);
		System.out.println(solution.lowestCommonAncestor(root, root.nodes[1], root.nodes[10]).val);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public static TreeNode[] nodes;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode createTree(Integer[] vals) {
		nodes = new TreeNode[vals.length];
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

	private static void print(TreeNode root) {
		if (root == null)
			return;

		print(root.left);
		System.out.print(root.val + "\t");
		print(root.right);
	}

}