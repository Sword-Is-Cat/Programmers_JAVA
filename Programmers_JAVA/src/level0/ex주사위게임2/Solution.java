package level0.ex주사위게임2;

class Solution {
	public int solution(int a, int b, int c) {
		int answer = 0;

		if (a == b && b == c) {
			answer = 27 * a * a * a * a * a * a;
		} else if (a == b || b == c || a == c) {
			answer = (a + b + c) * (a * a + b * b + c * c);
		} else {
			answer = a + b + c;
		}

		return answer;
	}
}