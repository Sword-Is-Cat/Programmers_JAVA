package SkillCheck_level2.Q2;

class Solution {
	public int[] solution(int brown, int yellow) {

		int width = 0, height = 0;

		int sum = brown / 2 + 2;

		for (int i = 2; i <= sum / 2; i++) {
			if ((i - 2) * (sum - i - 2) == yellow) {

				height = i;
				width = sum - height;
			}
		}

		int[] answer = { width, height };
		return answer;
	}
}