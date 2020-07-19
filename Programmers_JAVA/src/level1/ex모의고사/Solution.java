package level1.ex모의고사;

/* https://programmers.co.kr/learn/courses/30/lessons/42840 */

import java.util.ArrayList;
import java.util.List;

class Solution {
	public static int[] solution(int[] answers) {

		int score1 = 0;
		int score2 = 0;
		int score3 = 0;

		int[] ans1 = { 1, 2, 3, 4, 5 };
		int[] ans2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] ans3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		for (int i = 0; i < answers.length; i++) {

			if (answers[i] == ans1[i % 5])
				score1++;

			if (answers[i] == ans2[i % 8])
				score2++;

			if (answers[i] == ans3[i % 10])
				score3++;

		}

		int best = Math.max(score1, Math.max(score2, score3));

		List<Integer> list = new ArrayList<>();

		if (best == score1)
			list.add(1);
		if (best == score2)
			list.add(2);
		if (best == score3)
			list.add(3);

		int[] answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {

			answer[i] = list.get(i);
		}

		return answer;
	}

}
