package level1.ex콜라문제;

class Solution {
	public int solution(int a, int b, int n) {

		int answer = 0;

		while (n >= a) {
			n -= a - b;
			answer += b;
		}

		return answer;
	}
}