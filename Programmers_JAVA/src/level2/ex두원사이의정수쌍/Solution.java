package level2.ex두원사이의정수쌍;

class Solution {
	public long solution(int r1, int r2) {

		long s1 = (long) r1 * r1, s2 = (long) r2 * r2;
		long answer = 0;

		for (long x = 0; x < r2; x++) {

			if (x < r1) {
				answer += Math.floor(Math.sqrt(s2 - x * x)) - Math.ceil(Math.sqrt(s1 - x * x)) + 1;
			} else {
				answer += Math.floor(Math.sqrt(s2 - x * x));
			}
		}
		return answer * 4;
	}
}