package level1.ex과일장수;

import java.util.Arrays;

class Solution {
	public int solution(int k, int m, int[] score) {

		Arrays.sort(score);

		int answer = 0, index = score.length;

		while (index >= m) {
			index -= m;
			answer += score[index] * m;
		}

		return answer;
	}
}