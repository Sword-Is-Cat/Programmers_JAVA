package level3.ex등대;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
	public int solution(int n, int[][] lighthouse) {

		// [1] n개의 등대를 Node로 선언 O(n)
		Node[] array = new Node[n];
		for (int i = 0; i < array.length; i++)
			array[i] = new Node();

		// [2] lighthouse 연결구조에 따라 연결 적용 O(n)
		for (int[] conn : lighthouse) {
			array[conn[0] - 1].child.add(array[conn[1] - 1]);
			array[conn[1] - 1].child.add(array[conn[0] - 1]);
		}

		// [3] 임의의 노드 하나를 root로 지정하고 트리구조로 변경 O(n)
		buildTree(array[0], null);

		// [4] depth기준값으로 내림차순정렬 O(n*log(n))
		Arrays.sort(array, (a, b) -> b.depth - a.depth);

		int answer = 0;
		// [5] 하위depth 노드부터 등대 연결구조를 따라 불을 켬 O(n)
		for (Node node : array) {

			if (node.parent != null && !node.light && !node.parent.light) {
				answer++;
				node.parent.light = true;
			}
		}
		return answer;
	}

	void buildTree(Node node, Node parent) {

		node.depth = parent == null ? 0 : (parent.depth + 1);

		node.child.remove(parent);
		node.parent = parent;
		for (Node child : node.child) {
			buildTree(child, node);
		}
	}
}

class Node {

	int depth;
	boolean light;

	Node parent;
	HashSet<Node> child = new HashSet<>();
}