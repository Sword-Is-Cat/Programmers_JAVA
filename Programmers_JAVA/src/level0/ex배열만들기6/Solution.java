package level0.ex배열만들기6;

import java.util.Stack;

class Solution {
	public int[] solution(int[] arr) {

		Stack<Integer> stack = new Stack<>();

		for (int no : arr) {
			if (!stack.isEmpty() && no == stack.peek()) {
				stack.pop();
			} else {
				stack.push(no);
			}
		}

		return stack.isEmpty() ? new int[] { -1 } : stack.stream().mapToInt(i -> i).toArray();
	}
}