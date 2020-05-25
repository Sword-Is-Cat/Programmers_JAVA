package level3.ex기지국설치;

class Solution {
	public int solution(int n, int[] stations, int w) {

		int answer = 0;

		int area = 1;

		for (int i : stations) {

			while (area < i - w) {
				area += w * 2 + 1;
				answer++;
			}

			area = i + w + 1;

		}

		if (area <= n) {
			answer += (n - area) / (w * 2 + 1) + 1;
		}

		return answer;
	}
}