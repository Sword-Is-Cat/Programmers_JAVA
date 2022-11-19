package level2.ex택배상자;

import java.util.Stack;

class Solution {
	public int solution(int[] order) {

		int[] rank = new int[order.length];
		for (int i = 0; i < order.length; i++)
			rank[order[i] - 1] = i;

		Stack<Integer> stack = new Stack<>();
		int next = 0, idx = 0;

		while (idx < rank.length || (!stack.isEmpty() && stack.peek() == next)) {

			if (!stack.isEmpty() && stack.peek() == next) {
				stack.pop();
				next++;
			} else if (next == rank[idx]) {
				next++;
				idx++;
			} else {
				stack.push(rank[idx++]);
			}

		}

		return next;
	}
}