package asdf.test;

import java.util.Stack;

public class BSTIterator {

	/**
	 * (二叉搜索树迭代器实现 ) Implement an iterator over a binary search tree (BST). Your
	 * iterator will be initialized with the root node of a BST.
	 * 
	 * Calling next() will return the next smallest number in the BST.
	 * 
	 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
	 * memory, where h is the height of the tree.
	 */

	/**
	 * Your BSTIterator will be called like this: BSTIterator i = new
	 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
	 */

	private Stack<TreeNode> path;
	private TreeNode p;
	private boolean dire = true;// true 向下

	public BSTIterator(TreeNode root) {
		path = new Stack<TreeNode>();
		p = root;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		//辅助向上递归
		if(!dire){
			TreeNode f;
			while (!path.isEmpty()) {
				f = path.peek();
				if (f.right == p) {
					p = f;
					path.pop();
				}else{
					break;
				}
			}
		}		
		return !((path.isEmpty() && !dire) || p == null);
	}

	/** @return the next smallest number */
	public int next() {
		int res = 0;
		TreeNode f;
		if (dire) {// 向下
			while (p.left != null) {
				path.push(p);
				p = p.left;
			}
			res = p.val;
			if (p.right != null) {
				path.push(p);// 继续向下要记录路径
				p = p.right;
			} else
				dire = false;
		} else {
			while (!path.isEmpty()) {
				f = path.peek();
				if (f.left == p) {
					res = f.val;
					if (f.right != null) {
						p = f.right;
						dire = true;
					} else {
						p = f;
						path.pop();
					}
					break;
				}else{
					p = f;
					path.pop();
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Integer[] vals = { 7, 2, 5, 1, 3, 4, 6 };
		TreeNode root = TreeNode.createTree(vals);
		BSTIterator i = new BSTIterator(root);
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
		 i = new BSTIterator(null);
		 System.out.println(i.hasNext());
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
		if (vals.length < 1) {
			return null;
		}
		TreeNode[] nodes = new TreeNode[vals.length];
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] != null)
				nodes[i] = new TreeNode(vals[i]);
		}
		for (int i = 0; i < vals.length; i++) {
			if (nodes[i] != null) {
				if (2 * i + 1 < vals.length)
					nodes[i].left = nodes[2 * i + 1];
				if (2 * i + 2 < vals.length)
					nodes[i].right = nodes[2 * i + 2];
			}
		}
		return nodes[0];
	}
}