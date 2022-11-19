package level2.ex롤케이크자르기;

import java.util.HashSet;

class Solution {
	public int solution(int[] topping) {

		int length = topping.length;

		int[] leftCnt = new int[length + 1], rightCnt = new int[length + 1];

		HashSet<Integer> counter = new HashSet<>();

		for (int idx = 0; idx < length; idx++) {
			counter.add(topping[idx]);
			leftCnt[idx + 1] = counter.size();
		}

		counter.clear();

		for (int idx = length - 1; idx >= 0; idx--) {
			counter.add(topping[idx]);
			rightCnt[idx] = counter.size();
		}

		int answer = 0;

		for (int idx = 0; idx <= length; idx++) {
			if (leftCnt[idx] == rightCnt[idx])
				answer++;
		}

		return answer;
	}
}