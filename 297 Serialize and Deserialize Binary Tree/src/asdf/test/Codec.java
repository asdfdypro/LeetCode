package asdf.test;

public class Codec {

	/**
	 * (序列化树)Serialization is the process of converting a data structure or
	 * object into a sequence of bits so that it can be stored in a file or
	 * memory buffer, or transmitted across a network connection link to be
	 * reconstructed later in the same or another computer environment.
	 * 
	 * Design an algorithm to serialize and deserialize a binary tree. There is
	 * no restriction on how your serialization/deserialization algorithm should
	 * work. You just need to ensure that a binary tree can be serialized to a
	 * string and this string can be deserialized to the original tree
	 * structure.
	 * 
	 * 
	 * Note: Do not use class member/global/static variables to store states.
	 * Your serialize and deserialize algorithms should be stateless.
	 */

	private final static String NULL_STRING = new String(new char[] { 'x' });

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		if (root == null)
			return NULL_STRING;
		else {
			char[] res = new char[3];
			res[0] = 'Y';
			res[1] = (char) ((root.val & (0xFFFF << 16)) >> 16);
			res[2] = (char) ((root.val & (0xFFFF)));			
			return new String(res) + serialize(root.left) + serialize(root.right);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		char[] tree = data.toCharArray();
		int[] pos = { 0 };
		return deserialize(tree, pos);
	}

	private TreeNode deserialize(char[] tree, int[] pos) {
		if (tree[pos[0]++] == 'x')
			return null;
		else {
			int val = ((int) tree[pos[0]++]) << 16; 
					val+= ((int) tree[pos[0]++]);
			TreeNode root = new TreeNode(val);
			root.left = deserialize(tree, pos);
			root.right = deserialize(tree, pos);
			return root;
		}
	}

	public static void main(String[] args) {	
		
		Codec codec = new Codec();
		Integer[] nums = {700000,1,2,null,null,4,5};
		TreeNode root = TreeNode.createTree(nums);
		root.print();
		String tree = codec.serialize(root);
//		System.out.println(tree);
		root = codec.deserialize(tree);
		root.print();
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