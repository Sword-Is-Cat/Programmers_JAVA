package level1.ex체육복;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {

		int answer = 0;
		int[] have = new int[n];

		for (int i : lost)
			have[i - 1]--;

		for (int i : reserve)
			have[i - 1]++;

		for (int i = 0; i < n - 1; i++)
			if (have[i] * have[i + 1] < 0) {
				have[i] = 0;
				have[i + 1] = 0;
			}

		for (int i : have)
			if (i >= 0)
				answer++;

		return answer;
	}
}