package level3.ex모두0으로만들기;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public long solution(int[] a, int[][] edges) {

		Node[] nodes = new Node[a.length];
		for (int i = 0; i < a.length; i++)
			nodes[i] = new Node(i, a[i]);

		for (int[] edge : edges)
			nodes[edge[0]].addConnection(nodes[edge[1]]);

		long[] result = nodes[0].calculate();

		return result[0] == 0L ? result[1] : -1;
	}
}

class Node {

	int index;
	int value;
	Set<Node> conn = new HashSet<>();
	boolean visit = false;

	Node(int index, int value) {
		this.index = index;
		this.value = value;
	}

	void addConnection(Node node) {
		if (node != null) {
			conn.add(node);
			node.conn.add(this);
		}
	}

	long[] calculate() {
		long[] result = { 0L, 0L };

		if (!visit) {
			visit = true;
			for (Node node : conn) {
				long[] temp = node.calculate();
				result[0] += temp[0];
				result[1] += temp[1];
			}
			result[0] += value;
			result[1] += Math.abs(result[0]);
		}
		return result;
	}
}