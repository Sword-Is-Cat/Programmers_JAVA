package level2.ex점찍기;

class Solution {
	public long solution(int k, int d) {

		long answer = 0;

		for (int a = 0; a * k <= d; a++) {

			long dPow = (long) d * d;
			long akPow = (long) a * k * a * k;

			answer += (int) (Math.sqrt(dPow - akPow) / k) + 1;
		}

		return answer;
	}
}