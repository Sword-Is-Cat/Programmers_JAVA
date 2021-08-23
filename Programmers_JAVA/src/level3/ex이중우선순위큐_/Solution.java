package level3.ex이중우선순위큐_;

import java.util.LinkedList;

class Solution {
	public int[] solution(String[] operations) {

		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int i = 0; i < operations.length; i++) {

			String[] order = operations[i].split(" ");

			String cmd = order[0];
			int value = Integer.parseInt(order[1]);

			if (cmd.equals("I")) {
				list.add(value);
				list.sort((a, b) -> a - b);
			} else if (list.size() == 0) {
				continue;
			} else if (value > 0) {
				list.remove(list.size() - 1);
			} else {
				list.remove(0);
			}

		}

		int[] answer = { 0, 0 };

		if (list.size() != 0) {
			answer[0] = list.get(list.size() - 1);
			answer[1] = list.get(0);
		}

		return answer;

	}

}