package level0.ex순서쌍의개수;

class Solution {
	public int solution(int n) {
		int answer = 0;

		for (int div = 1; div * div <= n; div++) {
			if (n % div == 0) {
				answer++;
				if (n / div != div)
					answer++;
			}
		}

		return answer;
	}
}