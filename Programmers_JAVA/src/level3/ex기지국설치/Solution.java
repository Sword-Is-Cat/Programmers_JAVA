package level3.ex기지국설치;

class Solution {
	public int solution(int n, int[] stations, int w) {

		int answer = 0;

		int checker = 1;

		for (int i : stations) {

			while (checker < i - w) {
				checker += w * 2 + 1;
				answer++;
			}

			checker = i + w + 1;

		}

		if (checker <= n) {
			answer += (n - checker) / (w * 2 + 1) + 1;
		}

		return answer;
	}
}