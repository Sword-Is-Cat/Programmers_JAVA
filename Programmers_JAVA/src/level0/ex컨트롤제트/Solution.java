package level0.ex컨트롤제트;

import java.util.Stack;

class Solution {
	public int solution(String s) {

		Stack<Integer> stack = new Stack<>();
		int sum = 0;

		for (String query : s.split(" ")) {

			if ("Z".equals(query)) {

				sum -= stack.pop();

			} else {
				int no = Integer.parseInt(query);
				sum += no;
				stack.push(no);
			}

		}

		return sum;
	}
}