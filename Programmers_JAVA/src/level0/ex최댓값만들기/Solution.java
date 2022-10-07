package level0.ex최댓값만들기;

import java.util.Arrays;

class Solution {
	public int solution(int[] numbers) {
		Arrays.sort(numbers);

		return numbers[numbers.length - 1] * numbers[numbers.length - 2];
	}
}