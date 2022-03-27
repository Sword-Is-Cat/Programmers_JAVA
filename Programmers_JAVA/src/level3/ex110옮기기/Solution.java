package level3.ex110옮기기;

import java.util.Stack;

class Solution {

	final String UNIT = "011";

	public String[] solution(String[] s) {

		for (int i = 0; i < s.length; i++) {
			s[i] = solve(s[i]);
		}
		return s;
	}

	String solve(String str) {

		Stack<Character> stack = new Stack<>();
		StringBuilder sb = null;

		int cnt = 0;
		for (char ch : str.toCharArray()) {
			if (stack.size() > 1 && ch == '0') {
				char y = stack.pop();
				char x = stack.pop();
				if (x == '1' && y == '1') {
					cnt++;
				} else {
					stack.push(x);
					stack.push(y);
					stack.push(ch);
				}
			} else {
				stack.push(ch);
			}
		}

		sb = new StringBuilder();
		while (cnt-- > 0) {
			sb.append(UNIT);
		}
		String units = sb.toString();

		sb = new StringBuilder();
		boolean insert = true;
		while (!stack.isEmpty()) {
			if (insert && stack.peek() == '0') {
				insert = false;
				sb.append(units);
			}
			sb.append(stack.pop());
		}
		if (insert)
			sb.append(units);

		return sb.reverse().toString();
	}
}