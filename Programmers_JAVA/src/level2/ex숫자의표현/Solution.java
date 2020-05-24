package level2.ex숫자의표현;

class Solution {
	public int solution(int n) {
		int answer = 0;

		n *= 2;

		for (int i = 1; i * i < n; i++) {
			if (n % i == 0 && (i + n / i) % 2 == 1)
				answer++;
		}

		return answer;
	}
}