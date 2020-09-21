package level1.ex두개뽑아서더하기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

	public int[] solution(int[] numbers) {

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}

		int[] answer = new int[set.size()];

		int index = 0;
		for (int i : set)
			answer[index++] = i;

		Arrays.sort(answer);

		return answer;

	}
}