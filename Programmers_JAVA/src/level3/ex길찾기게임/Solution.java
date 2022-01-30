package level3.ex길찾기게임;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
	public int[][] solution(int[][] nodeinfo) {

		// 배열의 Node화
		Node root = getRoot(nodeinfo);

		// 전위순회배열생성
		List<Integer> preCircuit = getCircuitList(true, null, root);

		// 후위순회배열생성
		List<Integer> postCircuit = getCircuitList(false, null, root);

		int[][] answer = new int[2][nodeinfo.length];
		
		for(int i = 0 ; i<nodeinfo.length ; i++) {
			answer[0][i] = preCircuit.get(i);
			answer[1][i] = postCircuit.get(i);
		}
		
		return answer;
	}

	Node getRoot(int[][] nodeinfo) {

		PriorityQueue<Node> que = new PriorityQueue<>((a, b) -> (b.y - a.y));
		Node root = null;

		for (int i = 0; i < nodeinfo.length; i++)
			que.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));

		while (!que.isEmpty()) {
			if (root == null)
				root = que.poll();
			else
				root.add(que.poll());
		}

		return root;
	}

	List<Integer> getCircuitList(boolean isPrefix, List<Integer> list, Node node) {

		if (list == null)
			list = new ArrayList<>();
		
		if (node == null)
			return list;

		if (isPrefix)
			list.add(node.no);

		getCircuitList(isPrefix, list, node.left);
		getCircuitList(isPrefix, list, node.right);

		if (!isPrefix)
			list.add(node.no);

		return list;
	}

}

class Node {

	int no;
	int x;
	int y;
	Node left;
	Node right;

	Node(int no, int x, int y) {
		this.no = no;
		this.x = x;
		this.y = y;
	}

	public void add(Node node) {
		if (node == null)
			return;
		if (this.x < node.x) {
			// right
			if (right == null)
				right = node;
			else
				right.add(node);
		} else {
			// left
			if (left == null)
				left = node;
			else
				left.add(node);
		}
	}

}