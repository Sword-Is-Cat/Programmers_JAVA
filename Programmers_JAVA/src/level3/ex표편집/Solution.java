package level3.ex표편집;

import java.util.Stack;

class Solution {
	public String solution(int n, int k, String[] cmds) {

		Node[] nodes = new Node[n];
		Node cur = null;
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i);
			if (i != 0) {
				nodes[i].prev = nodes[i - 1];
				nodes[i - 1].next = nodes[i];
			}
			if (i == k)
				cur = nodes[i];
		}

		Stack<Node> recycle = new Stack<>();

		for (String cmd : cmds) {

			char order = cmd.charAt(0);

			if (order == 'C') {

				recycle.add(cur);

				if (cur.prev != null)
					cur.prev.next = cur.next;
				if (cur.next != null)
					cur.next.prev = cur.prev;

				cur = cur.next == null ? cur.prev : cur.next;

			} else if (order == 'Z') {

				Node temp = recycle.pop();

				if (temp.next != null)
					temp.next.prev = temp;
				if (temp.prev != null)
					temp.prev.next = temp;

			} else {

				int move = Integer.parseInt(cmd.substring(2));

				while (move > 0) {
					cur = order == 'U' ? cur.prev : order == 'D' ? cur.next : cur;
					move--;
				}
			}
		}

		while (cur.prev != null)
			cur = cur.prev;

		boolean[] exists = new boolean[n];

		while (cur != null) {
			exists[cur.index] = true;
			cur = cur.next;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++)
			sb.append(exists[i] ? 'O' : 'X');

		return sb.toString();
	}
}

class Node {
	int index;
	Node prev;
	Node next;

	Node(int index) {
		this.index = index;
	}
}