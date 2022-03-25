package level2.ex124나라의숫자;

import java.util.Stack;

public class Solution {

	public String solution(int n) {

		Stack<Integer> stack = new Stack<>();

		while (n > 0) {
			if (n % 3 == 0) {
				stack.push(4);
				n -= 3;
			} else {
				stack.push(n % 3);
			}
			n /= 3;
		}

		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty())
			sb.append(stack.pop());

		return sb.toString();
	}
}