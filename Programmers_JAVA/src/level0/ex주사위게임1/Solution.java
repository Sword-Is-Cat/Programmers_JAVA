package level0.ex주사위게임1;

class Solution {
	public int solution(int a, int b) {

		boolean aOdd = a % 2 == 1, bOdd = b % 2 == 1;

		int answer = 0;

		if (aOdd && bOdd) {
			answer = a * a + b * b;
		} else if (aOdd ^ bOdd) {
			answer = 2 * (a + b);
		} else {
			answer = Math.abs(a - b);
		}

		return answer;
	}
}