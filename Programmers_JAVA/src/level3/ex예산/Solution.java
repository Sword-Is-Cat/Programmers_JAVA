package level3.ex예산;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43237
 */

import java.util.Arrays;

class Solution {
	public int solution(int[] budgets, int M) {

		Arrays.sort(budgets);

		long sum = 0;

		for (int budget : budgets)
			sum += budget;

		if (sum < M)
			return budgets[budgets.length - 1];

		int index = budgets.length;

		while (sum > M) {

			if (index == 1)
				return M / budgets.length;

			index--;
			sum -= (budgets[index] - budgets[index - 1]) * (budgets.length - index);

		}

		int answer = budgets[index - 1];

		return answer + (int) (M - sum) / (budgets.length - index);
	}
}