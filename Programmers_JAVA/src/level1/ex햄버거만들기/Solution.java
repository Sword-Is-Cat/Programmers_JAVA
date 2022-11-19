package level1.ex햄버거만들기;

import java.util.Stack;

class Solution {
	public int solution(int[] ingredient) {

		Stack<Integer> stack = new Stack<>();

		for (int item : ingredient) {

			if (item == 1 && stack.size() > 2) {

				int temp1 = stack.pop(), temp2 = stack.pop(), temp3 = stack.pop();
				if (temp1 == 3 && temp2 == 2 && temp3 == 1) {
					continue;
				} else {
					stack.add(temp3);
					stack.add(temp2);
					stack.add(temp1);
					stack.add(item);
				}

			} else {
				stack.add(item);
			}

		}

		return (ingredient.length - stack.size()) / 4;
	}
}