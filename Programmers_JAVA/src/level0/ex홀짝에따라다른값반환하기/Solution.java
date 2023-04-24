package level0.ex홀짝에따라다른값반환하기;

class Solution {
	public int solution(int n) {
		int answer = 0;

		if (n % 2 == 0) {
			while (n > 0) {
				answer += n * n;
				n -= 2;
			}
		} else {
			answer = (n + 1) * (n + 1) / 4;
		}

		return answer;
	}
}