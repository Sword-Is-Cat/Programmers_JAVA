package level1.ex모의고사;

/* https://programmers.co.kr/learn/courses/30/lessons/42840 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public static int[] solution(int[] answers) {

		int[] scores = new int[3];
		int[][] pattern = new int[3][];
		pattern[0] = new int[] { 1, 2, 3, 4, 5 };
		pattern[1] = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
		pattern[2] = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		for (int qNo = 0; qNo < answers.length; qNo++) {
			for (int pttNo = 0; pttNo < pattern.length; pttNo++) {
				if (answers[qNo] == pattern[pttNo][qNo % pattern[pttNo].length]) {
					scores[pttNo]++;
				}
			}
		}

		int best = Arrays.stream(scores).max().getAsInt();

		List<Integer> list = new ArrayList<>();

		for (int j = 0; j < 3; j++) {
			if (best == scores[j])
				list.add(j + 1);
		}

		return list.stream().mapToInt(i -> i).toArray();
	}

}
