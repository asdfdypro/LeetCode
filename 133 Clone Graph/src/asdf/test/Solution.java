package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (复制图) Clone an undirected graph. Each node in the graph contains a label
	 * and a list of its neighbors.
	 * 
	 * OJ's undirected graph serialization:
	 * 
	 * Nodes are labeled uniquely. We use # as a separator for each node, and ,
	 * as a separator for node label and each neighbor of the node.
	 * 
	 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
	 * 
	 * The graph has a total of three nodes, and therefore contains three parts
	 * as separated by #.
	 * 
	 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
	 * 
	 * Second node is labeled as 1. Connect node 1 to node 2.
	 * 
	 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus
	 * forming a self-cycle.
	 */
	
	// 用map记录新旧关系
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
		cloneGraph(visited, node);
		return visited.get(node);
	}

	private void cloneGraph(Map<UndirectedGraphNode, UndirectedGraphNode> visited,
			UndirectedGraphNode node) {
		if (visited.get(node) != null)
			return;

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		visited.put(node, newNode);
		for (UndirectedGraphNode nextNode : node.neighbors) {
			cloneGraph(visited, nextNode);
			newNode.neighbors.add(visited.get(nextNode));
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		UndirectedGraphNode r0 = new UndirectedGraphNode(0);
		UndirectedGraphNode r1 = new UndirectedGraphNode(1);
		UndirectedGraphNode r2 = new UndirectedGraphNode(2);

		r0.add(r1).add(r2);
		r1.add(r2);
		r2.add(r2);

		r0.print();
		r1.print();
		r2.print();
		System.out.println();

		UndirectedGraphNode n0 = solution.cloneGraph(r0);
		n0.print();
		for (UndirectedGraphNode n : n0.neighbors) {
			n.print();
		}

	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

	public UndirectedGraphNode add(UndirectedGraphNode node) {
		this.neighbors.add(node);
		return this;
	}

	public void print() {
		System.out.print(label);
		System.out.print("=");
		System.out.println(this);
		System.out.print("\t");
		for (UndirectedGraphNode node : neighbors) {
			System.out.print(node);
			System.out.print(',');
		}
		System.out.println();
	}

	@Override
	public String toString() {

		return Integer.toHexString(hashCode());
	}
}
