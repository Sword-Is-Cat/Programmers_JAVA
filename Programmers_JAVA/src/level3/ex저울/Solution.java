package level3.ex저울;

import java.util.Arrays;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42886
 */

class Solution {
	public int solution(int[] weight) {

		Arrays.sort(weight);

		int sum = 0;

		for (int i = 0; i < weight.length; i++) {
			if (sum + 1 < weight[i])
				return sum + 1;

			sum += weight[i];
		}

		return sum + 1;

	}
}